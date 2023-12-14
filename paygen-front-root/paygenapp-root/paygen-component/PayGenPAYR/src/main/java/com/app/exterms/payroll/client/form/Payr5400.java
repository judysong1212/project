/**
 * 개별
 */
package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0520DTO;
import com.app.exterms.payroll.client.form.defs.Payr0470Def;
import com.app.exterms.payroll.client.form.defs.Payr0520Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr3200Service;
import com.app.exterms.payroll.client.service.Payr3200ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
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
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
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
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
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
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
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
import com.google.gwt.i18n.client.NumberFormat;
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
public class Payr5400  extends MSFPanel { 



/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리

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
	private FormPanel plFrmPayr3200;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	   
	   
	
	private Payr0520Def payr0520ToPayr3200Def = new Payr0520Def("PAYR05400_DDUCDIVCD"); // 그리드 테이블 컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel payr0520ToPayr3200GridPanel;

 
	private Payr0520Def payr0520Def = new Payr0520Def("PAYR05400"); // 그리드 테이블  컬럼 define
	// private MSFCustomForm msfCustomForm;
	private MSFGridPanel payr0520GridPanel;
	  
 //	  private Payr0200Def payr0200ToPayr3200Def  = new Payr0200Def("DDUCDIVCD");   //그리드 테이블 컬럼 define  
//      // private MSFCustomForm msfCustomForm; 
//      private MSFGridPanel payr0200ToPayr3200GridPanel;
//
//	 
//	  private Payr0200Def payr0200Def  = new Payr0200Def("PAYR0200");   //그리드 테이블 컬럼 define  
//	      // private MSFCustomForm msfCustomForm; 
//	  private MSFGridPanel payr0200GridPanel;

	private Payr0470Def lkPayr0470Def  = new Payr0470Def("PAYR4450");   //공제 그리드 테이블 컬럼 define  PAYR3200 
      // private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0470GridPanel;
	  
	  //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
      
	private ContentPanel cpGridPayr0520;
	  
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
		private ButtonBar topPayr3200Bar;
		private Button btnPayr3200Init;
		// private Button btnPayr3200Save;
		// private Button btnPayr3200Del;
		private Button btnPayr3200Sreach;
		private Button btnPayr3200Excel;
		
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		/** column  년도 : payYr */
		private ComboBox<BaseModel> srhPayYr;
		private ComboBox<BaseModel> srhPayrMangDeptCd; 				// 단위기관
		private ComboBox<BaseModel> srhEmymtDivCd; 					// 고용구분
		private ComboBox<BaseModel> srhRepbtyBusinDivCd; 			// 호봉제구분코드  
		private MSFMultiComboBox<ModelData> srhDeptCd; 				// 부서
		
		private ComboBox<BaseModel> srhDeptGpCd; 					//부서직종그룹코드	    
		private MSFMultiComboBox<ModelData> srhTypOccuCd; 			// 직종
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 	// 직종세
      
      
		private ComboBox<BaseModel> srhBusinCd; 					// 사업
		private TextField<String> srhHanNm; 						// 성명
		private TextField<String> srhResnRegnNum; 					// 주민번호
		private HiddenField<String> srhSystemkey; 					// 시스템키
	
		private ComboBox<BaseModel> srhDducDivCd; 					// 수당
		private ComboBox<BaseModel> dataStatus; 					// 상태코드
	
		private List<ModelData> mDtalistDeptCd;
		private List<ModelData> mDtalistTypOccuCd;
		private List<ModelData> mDtalistDtilOccuInttnCd;
		private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정

		private Boolean emptyCheck = false ;
		private boolean mutilCombo = false;
      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		private HiddenField<String> dpobCd;  			/** column 사업장코드 : dpobCd */ 
       
		private MSFTextField payItemCd;   				/** column 급여항목코드 : payItemCd */
		private MSFTextField payItemNm;   				/** column 급여항목 : payItemNm */
  
		private MSFNumberField pymtDducSum;   			/** column 지금공제금액 : pymtDducSum */
		private MSFNumberField pymtDducRate;   			/** column 지금공제율 : pymtDducRate */
		private MSFDateField pymtDducItemBgnnDt;   		/** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
		private MSFDateField pymtDducItemEndDt;   		/** column 지급공제항목종료일자 : pymtDducItemEndDt */ 
		private TextField<String> pymtDducItemNoteCtnt;	/** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
       
		private FileUploadField payr5400flUp; 			// 파일업로드처리 부분  
		private Boolean picBoolFile;
        
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
         // 검색 폼 바인딩 처리 함수 
       
        // private AuthAction authAction;  
		//  private Boolean boolChkAuth;  
		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
		/**
		 * 권한설정 처리 체크 AuthAction
		 */
		private void checkPayr3200Auth(String authAction, ListStore<BaseModel> bm) {
			// MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중");
	
			// 2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())&& gwtExtAuth.checkExtAuth(authAction, bm)) {
	
				if (!maskTracker) {
					unmask();
				}
				// MSFMainApp.unmaskMainPage();
				authExecEnabled();
				// ----------------------------------------------------
				gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
	
			}
		}
		
		private void authExecEnabled() { 
			//------------------
			Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd,srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
	                
			gwtAuthorization.formAuthFieldConfig(fldArrField);
	           	   
	              
			srhPayYr.setValue(lsPayYr.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
	           	 
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 시작 값순서
			 *  : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로없으면 ""
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
	               //  String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
	                // GWTAuthorization.formAuthPopConfig(plFrmPayr3200, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
	               //  GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
				   //gwtAuthorization.formAuthConfig(plFrmPayr3200, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
			/**
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
			 * 권한설정을 위한 콤보처리를 위한 메서드 종료
			 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			 */
			// srhDeptCd.fireEvent(Events.Add);
			srhDeptCd.getListView().fireEvent(Events.CheckChanged);
		       
		} 

		final Timer tmMask = new Timer() {
			public void run() {
				// if (maskTracker)
				// {
				if (lsEmymtDivCd.getCount() > 0) {
	
					cancel();
					unmask();
					authExecEnabled();
					maskTracker = true;
	
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
	
			HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();
	
			authMapDef.put("srhPayYr", Boolean.FALSE);
			authMapDef.put("srhDeptCd", Boolean.FALSE);
			authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
			authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
			// authMapDef.put("srhTypOccuCd",Boolean.FALSE);
	
			gwtExtAuth.setCheckMapDef(authMapDef);
	
			if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
				// 권한 검색조건처리를 위해 추가된 부분
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
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr3200FormBinding() {
	 	 
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
	private Payr3200ServiceAsync payr3200Service = Payr3200Service.Util.getInstance();	    
	 
	private ListStore<BaseModel> lsPayYr		 	= new ListStore<BaseModel>();		// 년도 
	private ListStore<BaseModel> lsEmymtDivCd		 = new ListStore<BaseModel>();		// 고용구분 
	private ListStore<BaseModel> lsRepbtyBusinDivCd	 = new ListStore<BaseModel>();		// 호봉제구분코드 
	
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();				// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();				// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>();		// 단위기관 
	private ListStore<BaseModel> lsDeptGpCd = new ListStore<BaseModel>();				// 부서직종그룹코드  
	private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();				// 직종 
	private ListStore<BaseModel> lsPayCd = new ListStore<BaseModel>(); 				// 급여구분
	
	private ListStore<BaseModel> lsDducDivCd = new ListStore<BaseModel>(); 			// 수당
	private ListStore<BaseModel> lsDataStatus = new ListStore<BaseModel>(); 			// 상태코드 
	
	private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();		//직종세
	
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종

	private PrgmComPayr0480DTO sysComPayr0480Dto; // 수당
	
	private Payr0520DTO payr0520Dto;
	
	private BaseModel record; 
	private Iterator<Record> records;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr3200(){
//    	payr0301GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr3200List(bass0200Dto, new AsyncCallback<List<Payr3200BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr3200(): "+caught), null);
//                msfPayr3200GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr3200BM> result) {
//            	composedPayr3200List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr3200List(List<Payr3200BM> listaMenu) {
//        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//        BaseTreeModel folder = new BaseTreeModel();
//        BaseTreeModel category = null;
//        while ( iter.hasNext() ) {
//        	Sysm0200BM mnu = iter.next();
//            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
//            BaseTreeModel bm = new BaseTreeModel();
//            bm.set("sysDivCd", mnu.getSysDivCd());
//            bm.set("mnuCd", mnu.getMnuCd());
//            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
//            bm.set("mnuNm", mnu.getMnuNm());
//            bm.set("mnuIcn", mnu.getMnuIcn()); 
//            bm.set("mnuTmbl", mnu.getMnuTmbl());
//            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
//            bm.set("mnuTipNm", mnu.getMnuTipNm());
//            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
//            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
//            bm.set("mnuPrntOrd", ord);
//            bm.set("useYn", mnu.getUseYn());
//            bm.set("mnuEpln", mnu.getMnuEpln());
//             
//            if (mnu.getHhrkMnuCd() == null) {
//                category = new BaseTreeModel();
//                category.setProperties(bm.getProperties());
//                folder.add(category);
//            } else {
//                if (category != null) {
//                    category.add(bm);
//                }
//            }
//        } 
//        msfPayr3200GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr3200Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr3200Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnPayr3200Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
//	  
	private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
            this.actionDatabase = ActionDatabase.INSERT;
            payr3200FormSave();
            break;
        case UPDATE:
            this.actionDatabase = ActionDatabase.UPDATE;
            payr3200FormSave();
            break;
        case DELETE:
            this.actionDatabase = ActionDatabase.DELETE;
			MessageBox.confirm("경고", "해당 수당대상자 정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						payr3200FormSave();
					}
				}
			});
            break;
        }
    }
    

    private void payr3200FormSave() { 
     
    	if (MSFSharedUtils.paramNotNull(records)) {
         
    		boolean doActionYn = true;
            
    		List<Payr0520DTO> listPayr0520dto = new ArrayList<Payr0520DTO>();  
              
    		while (records.hasNext()) {
            
				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				Payr0520DTO payr0520Dto = new Payr0520DTO();
             
                    
				payr0520Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));   	 			/** column 사업장코드 : dpobCd */
                payr0520Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));	/** column SYSTEMKEY : systemkey */
                payr0520Dto.setPayItemCd(MSFSharedUtils.allowNulls(payItemCd.getValue()));    		/** column 급여항목코드 : payItemCd */
                payr0520Dto.setPymtDducItemSilNum((Long)bmMapModel.get("pymtDducItemSilNum"));    	/** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
                payr0520Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
                payr0520Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));   		 			/** column 지급공제금액 : pymtDducSum */
                payr0520Dto.setPymtDducRate((Double)bmMapModel.get("pymtDducRate"));    			/** column 지급공제율 : pymtDducRate */
                payr0520Dto.setPymtDducFreeDtySum((Long)bmMapModel.get("pymtDducFreeDtySum"));    	/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                payr0520Dto.setPymtDducItemCretnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducItemCretnDivCd")));    			/** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
                payr0520Dto.setPymtDducItemBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("pymtDducItemBgnnDt"),"yyyyMMdd"));	/** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
                payr0520Dto.setPymtDducItemEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("pymtDducItemEndDt"),"yyyyMMdd"));    	/** column 지급공제항목종료일자 : pymtDducItemEndDt */
                payr0520Dto.setPymtDducItemDelYn((Boolean)bmMapModel.get("pymtDducItemDelYn"));    /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
                payr0520Dto.setPymtDducItemNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducItemNoteCtnt")));    /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
//                    payr0520Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                    payr0520Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                    payr0520Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                    payr0520Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                    payr0520Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                    payr0520Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
                  
				if (payr0520Dto.getPymtDducItemBgnnDt() == null || payr0520Dto.getPymtDducItemEndDt() == null) {
					doActionYn = false;
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),
							"시작일자와 종료일자를 입력해 주세요.", null);
				}
				listPayr0520dto.add(payr0520Dto);
			} 
              
			if (doActionYn) {
				payr3200Service.activityOnPayr3200(listPayr0520dto,actionDatabase, new AsyncCallback<Long>() {
					public void onFailure(Throwable caught) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr3200("
														+ actionDatabase.name()+ ") : " + caught),null);
					}

					public void onSuccess(Long result) {
						if (result == 0) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),actionDatabase
													+ "처리가 완료되지 않았습니다. 데이타를 확인하십시요.",null);
						} else {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
											actionDatabase + "처리가 " + result+ "건 완료 되었습니다.", null);

							payr0520ToPayr3200GridPanel.reload();
							payr0520GridPanel.reload();
							actionDatabase = ActionDatabase.UPDATE;
						}
					}
				});
			}
    	} else {
			MessageBox.alert(actionDatabase.name() + "선택",
					actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
			return;
    	}
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
//	private void Payr3200Print(String fileName) {
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
//		List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
	  
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr3200Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createStandardForm();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	  
	public ContentPanel getViewPanel() {
		if (panel == null) {

			// 콤보 권한초기화
			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr3200Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색필드를 적용
			createStandardForm(); 	// 기본정보필드
			createSubForm(); 		// 엑셀 업로드
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");
				    
				    /**
			          * Create the relations 
			          */
//					   final RelationDef  relPayr0200ToPayr3200 = new RelationDef(payr0200Def);
//					   relPayr0200ToPayr3200.addJoinDef("dpobCd", "dpobCd");
//					   relPayr0200ToPayr3200.addJoinDef("dducDivCd", "dducDivCd"); 
//					   relPayr0200ToPayr3200.setLinkedObject(payr0200GridPanel);
//					   payr0200ToPayr3200Def.addRelation(relPayr0200ToPayr3200); 
//			           
//			 
//			           // DETAILS 
//			           final Grid payr0259Grid = payr0200ToPayr3200GridPanel.getMsfGrid().getGrid();
//			           payr0259Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
//			              public void handleEvent(BaseEvent be) {  
//			            	  if (payr0200ToPayr3200GridPanel.getCurrentlySelectedItem() != null) { 
//			            		 
//			            		  payr0200Def.synchronizeGridDetail(
//			            				  payr0200ToPayr3200GridPanel.getCurrentlySelectedItem(),
//			            				  payr0200GridPanel ); 
//			            	   }
//			            	  payr0200GridPanel.reload(); 
//			                
//			              }
//			          });
   
				    
                  final RelationDef  relPayr0520ToPayr3200 = new RelationDef(payr0520ToPayr3200Def,false);
                  relPayr0520ToPayr3200.addJoinDef("dpobCd", "dpobCd");
                  relPayr0520ToPayr3200.addJoinDef("emymtDivCd", "emymtDivCd"); 
                  relPayr0520ToPayr3200.addJoinDef("deptCd", "deptCd"); 
                  relPayr0520ToPayr3200.addJoinDef("businCd", "businCd"); 
                  relPayr0520ToPayr3200.addJoinDef("typOccuCd", "typOccuCd"); 
                  relPayr0520ToPayr3200.addJoinDef("dtilOccuInttnCd", "dtilOccuInttnCd"); 
                  relPayr0520ToPayr3200.addJoinDef("systemkey", "systemkey"); 
                  relPayr0520ToPayr3200.addJoinDef("hanNm", "hanNm"); 
                  relPayr0520ToPayr3200.addJoinDef("payItemCd", "payItemCd"); 
                  relPayr0520ToPayr3200.addJoinDef("pymtDducDivCd", "pymtDducDivCd");  
                  relPayr0520ToPayr3200.addJoinDef("1", "dataStatus");  
                  relPayr0520ToPayr3200.setLinkedObject(payr0520ToPayr3200GridPanel);
                  payr0520Def.addRelation(relPayr0520ToPayr3200); 
 
        
            // DETAILS 
            final Grid payr0520ToPayr3200Grid = payr0520ToPayr3200GridPanel.getMsfGrid().getGrid();
            payr0520ToPayr3200Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
            	public void handleEvent(BaseEvent be) {  
            		if (payr0520ToPayr3200GridPanel.getCurrentlySelectedItem() != null) { 
                            
            			payr0520Def.synchronizeGridDetail(payr0520ToPayr3200GridPanel.getCurrentlySelectedItem(),payr0520GridPanel ); 
            			
            			IColumnFilter filters = null;
						payr0520GridPanel.getTableDef().setTableColumnFilters(filters);
                            
                        payr0520GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS);
                        payr0520GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_02, SimpleColumnFilter.OPERATOR_EQUALS);
                        payr0520GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
                        payr0520GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
                        payr0520GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("deptCd", PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("typOccuCd", PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                         //    payr0520GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd",PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
                        payr0520GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
                            // payr0520GridPanel.getTableDef().addColumnFilter("dataStatus", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                        payr0520GridPanel.getTableDef().addColumnFilter("dataStatus", MSFSharedUtils.getSelectedComboValue(dataStatus,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
                             
                        setRecord(payr0520ToPayr3200GridPanel.getCurrentlySelectedItem());
                        setFormData();
           
                           //  payr0520GridPanel.reload(); 
                          }
                        
                     }
                 });  
				     
				            
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
	public Payr5400() {

		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Payr5400(String txtForm) {
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
	private void createPayr3200Form() {
		  
		plFrmPayr3200 = new FormPanel();
		plFrmPayr3200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ lblPayrConst.title_Payr5400());
		// plFrmPayr3200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 개별공제관리"));
		plFrmPayr3200.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr3200.setBodyStyleName("pad-text");
		plFrmPayr3200.setPadding(2);
		plFrmPayr3200.setFrame(true);
			
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr5400(),"PAYR5400");
				}
			});
		plFrmPayr3200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr3200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		// 멀티콤보박스 닫기
		plFrmPayr3200.addListener(Events.OnClick, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (mutilCombo) {
	             	if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
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
			} 
		});

		topPayr3200Bar = new ButtonBar();
		topPayr3200Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnPayr3200Init = new Button("초기화");
		btnPayr3200Init.setIcon(MSFMainApp.ICONS.new16());
		topPayr3200Bar.add(btnPayr3200Init);
		btnPayr3200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 초기화
				formInit();
			}
		});

		btnPayr3200Sreach = new Button("조회");
		btnPayr3200Sreach.setIcon(MSFMainApp.ICONS.search16());
		topPayr3200Bar.add(btnPayr3200Sreach);
		btnPayr3200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});

		btnPayr3200Excel = new Button("엑셀");
		btnPayr3200Excel.setIcon(MSFMainApp.ICONS.excel16());
		btnPayr3200Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});
//		topPayr3200Bar.add(btnPayr3200Excel);

		plFrmPayr3200.add(topPayr3200Bar);

		// 파일업로드 처리
		plFrmPayr3200.setAction("myurl");
		plFrmPayr3200.setEncoding(Encoding.MULTIPART);
		plFrmPayr3200.setMethod(Method.POST);

		vp.add(plFrmPayr3200);
		//엣지변환
		//plFrmPayr3200.setSize("990px", "680px");
		plFrmPayr3200.setSize("990px", "730px");
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
     
		srhSystemkey = new HiddenField<String>();
		// srhPyspGrdeCd= new HiddenField<String>();

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
		sysComPayr0480Dto = new PrgmComPayr0480DTO();

		// baseModel
		BaseModel dataStat = new BaseModel();
		dataStat.set("commCd", "0");
		dataStat.set("commNm", "전체");
		lsDataStatus.add(dataStat);
		dataStat = new BaseModel();
		dataStat.set("commCd", "1");
		dataStat.set("commNm", "현재일기준");
		lsDataStatus.add(dataStat);
		dataStat = new BaseModel();
		dataStat.set("commCd", "2");
		dataStat.set("commNm", "현재일기준종료");
		lsDataStatus.add(dataStat);
		 
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
        lsPayYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
        //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
         
		 
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
		
		//호봉
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		  
		//--------------------수당 코드 불러 오는 함수 --------------------------------------------------
		//수당
		lsDducDivCd = PrgmComComboUtils.getSinglePayr0480ComboData(sysComPayr0480Dto);
		//--------------------수당 코드 불러 오는 함수 --------------------------------------------------
		 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 직종 콤보박스 처리 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 */
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

				mDtalistTypOccuCd = PayrUtils
						.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);

			}
		});   

		//--------------------부서 불러 오는 함수 ------------------------------------------------
		//	 lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
		//--------------------부서 불러 오는 함수 ------------------------------------------------
		 //-------------------관리부서 추가  
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

		lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd);
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});   
	    //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 * 공제  콤보박스 처리  시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	  	     ContentPanel dducDivCdGrid = new ContentPanel();  
	  		 dducDivCdGrid.setVisible(false);
	  		    
	  		   //  콤보처리 
	  		   payr0470GridPanel = new MSFGridPanel(lkPayr0470Def, false, false, false, true); 
	  		   payr0470GridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
	  			       public void handleEvent(ComponentEvent be) {  
	  			    	 payr0470GridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
	  			          public void handleEvent(StoreEvent<BaseModel> be) {  
	  			        	lsDducDivCd.add(payr0470GridPanel.getMsfGrid().getStore().getModels()); 
	  			        	  
	  			          }  
	  			        });  
	  			       
	  			      }  
	  			    });  
	  	  
	  	  dducDivCdGrid.add(payr0470GridPanel); 
	  	  plFrmPayr3200.add(dducDivCdGrid); 
		  */
	  		
		plFrmPayr3200.setLayout(new FlowLayout());

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
//		lcSchLeft.setStyleAttribute("paddingRight", "10px");

		LayoutContainer layoutContainery = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainery.setLayout(frmlytSch);
		layoutContainery.setBorders(false);
	    
		srhPayYr = new ComboBox<BaseModel>();
		srhPayYr.setName("srhPayYr");
		srhPayYr.setFieldLabel("수당년도");
		srhPayYr.setForceSelection(true);
		srhPayYr.setMinChars(1);
		srhPayYr.setDisplayField("yearDisp");
		srhPayYr.setValueField("year");
		srhPayYr.setTriggerAction(TriggerAction.ALL);
		srhPayYr.setEmptyText("--수당년도--");
		srhPayYr.setSelectOnFocus(true);
		srhPayYr.setStore(lsPayYr);
	    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
               
            	checkPayr3200Auth("srhPayYr", lsPayYr );  
              
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
	    
		layoutContainery.add(srhPayYr, new FormData("100%"));
		
	    LayoutContainer layoutContainer_4 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_4.setLayout(frmlytSch);
	    
	    dataStatus = new ComboBox<BaseModel>();
	    dataStatus.setName("dataStatus");
	    dataStatus.setForceSelection(true);
	    dataStatus.setMinChars(1);
	    dataStatus.setDisplayField("commNm");
	    dataStatus.setValueField("commCd");
	    dataStatus.setTriggerAction(TriggerAction.ALL);
	   // dataStatus.setEmptyText("--공제선택--");
	    dataStatus.setSelectOnFocus(true); 
	    dataStatus.setReadOnly(false);
	    dataStatus.setEnabled(true); 
	    dataStatus.setStore(lsDataStatus);  
	    dataStatus.setFieldLabel("출력조건"); 
	    lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {   
            	 EventType type = be.getType();
		    	   if (type == Store.Add) { 
		    		   dataStatus.setValue(lsDataStatus.getAt(1));
              	 }
            }
        });    
//	    dataStatus.select(0);
	    layoutContainer_4.add(dataStatus, new FormData("100%"));
	   
	    layoutContainer_4.setBorders(false);
	    

		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytSch);
		layoutContainer.setBorders(false);
	    
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
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr3200Auth("srhDeptCd", lsDeptCd); 
              	 }
                
            }
        });    
        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
            @Override
           public void handleEvent(ComponentEvent ce) { 
                    
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
          
             
	    layoutContainer.add(srhDeptCd, new FormData("100%"));
	    
	    LayoutContainer layoutContainer_14 = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_14_1 = new LayoutContainer();
	    
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer_14_1.setLayout(frmlytSch);
	   
	    layoutContainer_14_1.setBorders(false);
	    
	    srhEmymtDivCd =  new ComboBox<BaseModel>(); 
        srhEmymtDivCd.setName("srhEmymtDivCd");
        srhEmymtDivCd.setForceSelection(true);
        srhEmymtDivCd.setAllowBlank(false);
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
		                	checkPayr3200Auth("srhEmymtDivCd", lsEmymtDivCd); 
		                	
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
	    layoutContainer_14_1.add(srhEmymtDivCd, new FormData("100%"));
	    layoutContainer_14.add(layoutContainer_14_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    
	    LayoutContainer layoutContainer_14_2 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    frmlytSch = new FormLayout(); 
	    frmlytSch.setDefaultWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_14_2.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(true);
	    srhRepbtyBusinDivCd.setHideLabel(true);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setDisplayField("commCdNm");
	    srhRepbtyBusinDivCd.setValueField("commCd");
	    srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	    srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
	    srhRepbtyBusinDivCd.setSelectOnFocus(true); 
	    srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
	    srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
	    srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
	    srhRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    layoutContainer_14_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer_14_2.setBorders(false);
	    layoutContainer_14.add(layoutContainer_14_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    
	    
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_10.setLayout(frmlytSch);
	    layoutContainer_10.setBorders(false);
	    
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
	    layoutContainer_10.add(srhBusinCd, new FormData("100%"));
	    

	 
	    fieldSet.add(lcSchCol, new FormData("100%"));
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lcSchLeft.setLayout(frmlytSch);
	    
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
		                	checkPayr3200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
              	 }
                
            }
        });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
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
	    lcSchLeft.add(srhPayrMangDeptCd, new FormData("100%"));
	    
	    
//	    lcSchCol.add(layoutContainery,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15)); 	// 수당년도
//	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 			// 단위기관
//	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	// 고용구분
//	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));	// 부서
//	    lcSchCol.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));	// 사업
	    
	    lcSchCol.add(layoutContainery,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.13)); 	// 수당년도
	    lcSchCol.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17)); 	// 출력조건
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27)); 			// 단위기관
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 고용구분
	    
	     
	    
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
	 
	    LayoutContainer layoutContainer_1 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(70); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_1.setLayout(frmlytSch);
        layoutContainer_1.setBorders(false); 
        

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
        srhTypOccuCd.setLabelSeparator("");
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.setHideLabel(true);
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setWidth(100);
//        srhTypOccuCd.setFieldLabel("직종");
        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
            @Override
           public void handleEvent(ComponentEvent ce) {    
            	 //2015.11.30 추가 
           	 displayDtilOccuInttnCd(); 
            } 
        }); 
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
		    		   }
	            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                //	checkPayr3200Auth("srhTypOccuCd", lsTypOccuCd); 
              	 } 
                
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
        
	    layoutContainer_1.add(lcTypOccuCd, new FormData("100%"));
	    
	    
	  
	    
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	    
	    
	    LayoutContainer layoutContainer_5 = new LayoutContainer();
	    layoutContainer_2.add(layoutContainer_5, new FormData("100%"));
	    layoutContainer_5.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_6 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_6.setLayout(frmlytSch);
	    
	    srhHanNm = new TextField<String>();
	    srhHanNm.setName("srhHanNm");
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
	    			fnPopupPsnl0100();
	            }
	            super.componentKeyDown(event);
	    	}
	    });
	    
	    
//	    srhHanNm.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
////                super.componentKeyUp(event);
//                srhHanNm.validate();
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                    
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                    
//                    MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사  
//                    
//                    final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
//                    
//                    popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
//                        public void handleEvent(BaseEvent be) {
//                            if (!"".equals(popBindingCom0100.getModel().get("hanNm"))) { 
//                                srhSystemkey.setValue((String)popBindingCom0100.getModel().get("systemkey"));   //시스템키
//                                srhHanNm.setValue((String)popBindingCom0100.getModel().get("hanNm"));
//                                srhResnRegnNum.setValue((String)popBindingCom0100.getModel().get("resnRegnNum"));   //주민번호 
//                            }  
//  
//                        }
//                    });
//                }
//            }
//         });
//	    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                }
//             
//            } 
//      }); 
	    layoutContainer_6.add(srhHanNm, new FormData("100%"));
	    srhHanNm.setFieldLabel("성명");
	    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
	    layoutContainer_6.setBorders(false);
	    
	    Button btnHanNm = new Button("검색");
	    layoutContainer_5.add(btnHanNm);
	    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
  	    	public void handleEvent(ButtonEvent e) {
  	    		
  	    	  srhSystemkey.setValue("");
              srhResnRegnNum.setValue("");
  	    		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
  	    		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
  	    		//검색.처리하면됨.
//  	    	  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사 
//  	    	 
//  	    		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
//  	    		
//  	    		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
//		            public void handleEvent(BaseEvent be) {
//		            	if (!"".equals(popBindingCom0100.getModel().get("hanNm"))) { 
//		            		srhSystemkey.setValue((String)popBindingCom0100.getModel().get("systemkey"));   //시스템키
//		            		srhHanNm.setValue((String)popBindingCom0100.getModel().get("hanNm"));
//		            		srhResnRegnNum.setValue((String)popBindingCom0100.getModel().get("resnRegnNum"));   //주민번호 
//		            	}  
// 
//		            	
//		            }
//		        });
              fnPopupPsnl0100();
  	    		  
  	    	}
  	    });
	    
	    LayoutContainer layoutContainer_7 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setDefaultWidth(0);
//	    frmlytSch.setLabelWidth(1); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_7.setLayout(frmlytSch);
	    
	    /** column 주민등록번호 : resnRegnNum */
	    srhResnRegnNum = new TextField<String>();
	    srhResnRegnNum.setHideLabel(true);
//	    srhResnRegnNum.setLabelSeparator("");
	    srhResnRegnNum.setName("srhResnRegnNum");
	    new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
	    srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
            @Override
            public void handleEvent(BaseEvent be) {  
                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
                    srhSystemkey.setValue("");
                    srhHanNm.setValue("");
                }
             
            } 
      }); 
	   // srhResnRegnNum.setFieldLabel("주민번호");
	    layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	    layoutContainer_7.setBorders(false);
	    layoutContainer_5.setBorders(false);
	    
	    
	    
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(70); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_2.setLayout(frmlytSch);
	    layoutContainer_2.setBorders(false);
	    
	    
//	    layoutContainer_13.add(layoutContainer_3 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));	// 수당	
//	    layoutContainer_13.add(layoutContainer_4 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.17));	// 출력조건
//	    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));	// 직종
//	    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));	// 성명
	    
	    layoutContainer_13.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 수당	
	    layoutContainer_13.add(layoutContainer ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));		// 부서
	    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));	// 직종
	    
	    fieldSet.add(layoutContainer_13);
	    
	    
	    
        LayoutContainer lcSchCol3 = new LayoutContainer();
        lcSchCol3.setLayout(new ColumnLayout());
	    
//        LayoutContainer layoutContainer_16 = new LayoutContainer();
//        
//        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0); 
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//        layoutContainer_16.setLayout(frmlytSch);
        
        LayoutContainer layoutContainer_3 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_3.setLayout(frmlytSch);
	    
	    srhDducDivCd = new ComboBox<BaseModel>();
	    srhDducDivCd.setName("srhDducDivCd");
	    srhDducDivCd.setForceSelection(true);
	    srhDducDivCd.setMinChars(1);
	    srhDducDivCd.setDisplayField("payExtpyNm");
	    srhDducDivCd.setValueField("payExtpyCd");
	    srhDducDivCd.setTriggerAction(TriggerAction.ALL);
	    srhDducDivCd.setEmptyText("--수당선택--");
	    srhDducDivCd.setSelectOnFocus(true); 
	    srhDducDivCd.setReadOnly(false);
	    srhDducDivCd.setEnabled(true); 
	    srhDducDivCd.setStore(lsDducDivCd);  
	    srhDducDivCd.setFieldLabel("수당"); 
	    layoutContainer_3.add(srhDducDivCd, new FormData("100%"));
	    
	    layoutContainer_3.setBorders(false);
	    
	    
        lcSchCol3.add(layoutContainer_10 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 사업
        lcSchCol3.add(layoutContainer_3 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));	// 출력조건
        lcSchCol3.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));		// 성명
        
        
        fieldSet.add(lcSchCol3, new FormData("100%"));

        
        
        
		
	    plFrmPayr3200.add(fieldSet); 
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
		layoutContainer_1.setLayout(new FormLayout());
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize("302px", "455px");
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("수당항목");
		fldstNewFieldset.setCollapsible(false);
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_1.setBorders(false);
		
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FormLayout());
		
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize(655, 100);
		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("기본정보");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.setStyleAttribute("marginTop", "10px"); 
		fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(655, 345);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("수당대상자정보");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
		
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.68));
		layoutContainer_2.setBorders(false);
		 
		    
		plFrmPayr3200.add(layoutContainer);
		layoutContainer.setBorders(false); 
		    
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
	private LayoutContainer occupationalRTop() {
     
		dpobCd = new HiddenField<String>();  //사업장코드 
     
		LayoutContainer lcTabFormLayer = new LayoutContainer();
	 
		ContentPanel cp01 = new ContentPanel();   
		cp01.setBodyBorder(false); 
		cp01.setHeaderVisible(false);   
		cp01.setLayout(new FitLayout());      
		cp01.setSize(628, 95);  
	   	
	    
	    
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());
	   
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());
	   
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_5.setLayout(frmlytSch);
	   
		payItemCd = new MSFTextField();
		payItemCd.setReadOnly(true);
		layoutContainer_5.add(payItemCd, new FormData("100%"));
		payItemCd.setFieldLabel("수당코드");
		payItemCd.setReadOnly(true);
		layoutContainer_4.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_5.setBorders(false);
	   
		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_6.setLayout(frmlytSch);
		payItemNm = new MSFTextField();
		payItemNm.setReadOnly(true);
		layoutContainer_6.add(payItemNm, new FormData("100%"));
		payItemNm.setFieldLabel("수당명");
		payItemNm.setReadOnly(true);
		layoutContainer_4.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_6.setBorders(false);
		layoutContainer.add(layoutContainer_4);
		layoutContainer_4.setBorders(false);
	   
//	   LayoutContainer layoutContainer_7 = new LayoutContainer();
//	   layoutContainer_7.setLayout(new ColumnLayout());
//	   
//	   LayoutContainer layoutContainer_8 = new LayoutContainer();
//	   frmlytSch = new FormLayout();  
//	   frmlytSch.setLabelWidth(80); 
//	   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	   layoutContainer_8.setLayout(frmlytSch);
//	   
//	   ComboBox comboBox = new ComboBox();
//	   comboBox.setStore(new ListStore());
//	   layoutContainer_8.add(comboBox, new FormData("100%"));
//	   comboBox.setFieldLabel("급여계산구분");
//	   layoutContainer_7.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//	   layoutContainer_8.setBorders(false);
//	   layoutContainer.add(layoutContainer_7);
//	   layoutContainer_7.setBorders(false);
	   
	   
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());
	   
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_3.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(80); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		layoutContainer_1.setLayout(frmlytSch);
	    
       
		pymtDducSum = new MSFNumberField();
		pymtDducSum.setAllowDecimals(true); 
		pymtDducSum.setPropertyEditorType(Long.class); 
		pymtDducSum.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_1.add(pymtDducSum, new FormData("100%"));
		pymtDducSum.setFieldLabel("수당금액");
		layoutContainer_1.setBorders(false);
	   
  	  	LayoutContainer layoutContainer_2 = new LayoutContainer();
  	  	layoutContainer_3.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
  	  	frmlytSch = new FormLayout();  
  	  	frmlytSch.setLabelWidth(80); 
  	  	frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
  	  	layoutContainer_2.setLayout(frmlytSch);
  	 
		pymtDducRate = new MSFNumberField();
		pymtDducRate.setAllowDecimals(true);
		pymtDducRate.setPropertyEditorType(Double.class);
		pymtDducRate.setFormat(NumberFormat.getDecimalFormat());
		layoutContainer_2.add(pymtDducRate, new FormData("100%"));
		pymtDducRate.setFieldLabel("율");
		layoutContainer_2.setBorders(false);
		layoutContainer.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);
	   
		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);
 
		pymtDducItemBgnnDt = new MSFDateField();
		new DateFieldMask(pymtDducItemBgnnDt, "9999.99.99"); 
		pymtDducItemBgnnDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		layoutContainer_10.add(pymtDducItemBgnnDt, new FormData("100%"));
		pymtDducItemBgnnDt.setFieldLabel("시작일자");
		layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_10.setBorders(false);
	   
		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(80);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytSch);
	   
		pymtDducItemEndDt = new MSFDateField();
		new DateFieldMask(pymtDducItemEndDt, "9999.99.99"); 
		pymtDducItemEndDt.setPropertyEditor(new DateTimePropertyEditor(MSFMainApp.MSFCONSTANTS.DateFormat())); 
		layoutContainer_11.add(pymtDducItemEndDt, new FormData("100%"));
		pymtDducItemEndDt.setFieldLabel("종료일자");
		layoutContainer_9.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	   
		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytSch = new FormLayout();  
//	   frmlytSch.setLabelWidth(80); 
//	   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	   	layoutContainer_12.setLayout(frmlytSch);
	   
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
	   
	   
		Button button = new Button("재적용");
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				gridDataReset();
			}
		});
	   
		btnBar.add(button);

		layoutContainer_12.add(btnBar);
	   
		layoutContainer_9.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	   
	   
	   
		layoutContainer_11.setBorders(false);
		layoutContainer.add(layoutContainer_9);
		layoutContainer_9.setBorders(false);

		cp01.add(layoutContainer);
		layoutContainer.setBorders(false);
	   
	   // private TextField<String> pymtDducItemNoteCtnt;   /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
       
	   
//	   cp01.addButton(new Button("재적용", new SelectionListener<ButtonEvent>() {   
//	      @Override  
//	      public void componentSelected(ButtonEvent ce) {   
//	         gridDataReset();
//	      }   
//	  	}));  
//	      
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	 
	}
 
 
	private void createSubForm() {
	  
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setHeadingHtml("");
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout());
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
		    
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		layoutContainer_21.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_21.setLayout(frmlytSch);
	    layoutContainer_21.setBorders(false);
	    
		payr5400flUp = new FileUploadField();
		payr5400flUp.setName("payr5400flUp");
		payr5400flUp.setValidator(new Validator() {  
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
		layoutContainer_21.add(payr5400flUp, new FormData("100%"));
		payr5400flUp.setFieldLabel("개별수당");
		  
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnButton01 = new Button("업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
               	xlsImportData(); 
			}
		});
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_42 = new LayoutContainer(); 
		//layoutContainer_42.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_42.setLayout(frmlytSch);
		
		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				fnPopupCommP500();  
			}
		}); 
		layoutContainer_42.add(btnButton02, new FormData("100%"));
		layoutContainer_42.setBorders(false);
		
		layoutContainer_2.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_2.add(layoutContainer_42,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
		hbld_layoutContainer_2.setFlex(1.0);
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		
		layoutContainer.add(layoutContainer_1);
		fldstNewFieldset.add(layoutContainer);
		
		plFrmPayr3200.add(fldstNewFieldset);
	  
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
 
/** 수당항목 그리드 **/
private LayoutContainer occupationalLeft() {
   
   LayoutContainer lcTabFormLayer = new LayoutContainer();

 
       ContentPanel cp01 = new ContentPanel();   
       cp01.setBodyBorder(false); 
       cp01.setHeaderVisible(false);   
       cp01.setLayout(new FitLayout());      
       cp01.setSize(290, 430);  
       
       //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
//     payr0200ToPayr3200GridPanel = new MSFGridPanel(payr0200ToPayr3200Def, false, false, false, false);
//     payr0200ToPayr3200GridPanel.setHeaderVisible(false);  
//     payr0200ToPayr3200GridPanel.setBodyBorder(true);
//     payr0200ToPayr3200GridPanel.setBorders(true);
//       //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//      
//       cp01.add(payr0200ToPayr3200GridPanel); 
       
     payr0520ToPayr3200GridPanel = new MSFGridPanel(payr0520ToPayr3200Def, false, false, false, false);
     payr0520ToPayr3200GridPanel.setHeaderVisible(false);  
     payr0520ToPayr3200GridPanel.setBodyBorder(true);
     payr0520ToPayr3200GridPanel.setBorders(true); 
       //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
      
     cp01.add(payr0520ToPayr3200GridPanel); 
       
       
    lcTabFormLayer.add(cp01); 
     
    return lcTabFormLayer;  
   
}  

 private LayoutContainer occupationalRBottom() {
	   

     LayoutContainer lcTabFormLayer = new LayoutContainer();
 
	  cpGridPayr0520 = new ContentPanel();   
	   cpGridPayr0520.setBodyBorder(false); 
	   cpGridPayr0520.setHeaderVisible(false);   
	   cpGridPayr0520.setLayout(new FitLayout());      
	   cpGridPayr0520.setSize(635, 320);  
	   
	    
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
//		  payr0200GridPanel = new MSFGridPanel(payr0200Def, false, false, false, false);
//		  payr0200GridPanel.setHeaderVisible(false);  
//		  payr0200GridPanel.setBodyBorder(true);
//		  payr0200GridPanel.setBorders(true);
//	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
//	    
//	     cp01.add(payr0200GridPanel); 
	   
     payr0520GridPanel = new MSFGridPanel(payr0520Def, false, false, false, false,false);
     payr0520GridPanel.setHeaderVisible(false);  
     payr0520GridPanel.setBodyBorder(true);
     payr0520GridPanel.setBorders(true); 
    //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
     final Grid payr0520Grid = payr0520GridPanel.getMsfGrid().getGrid();
     payr0520Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {  
         if (payr0520GridPanel.getCurrentlySelectedItem() != null) {   
             
        	 payr0520GridPanel.setGridRowFormBind(payr0520GridPanel.getCurrentlySelectedItem());
        	 
             setRecord(payr0520GridPanel.getCurrentlySelectedItem());
             setFormDataMapping(); 
          } 
        }
    }); 
     cpGridPayr0520.add(payr0520GridPanel);
  	
     cpGridPayr0520.addButton(new Button("대상선택", MSFMainApp.ICONS.addSmall(), new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {   
	          payr0520GridPanel.getMsfGrid().clearData();
	          fnPopupPsnl0110() ;
	      }   
  	}));  
	     
  	   
     cpGridPayr0520.addButton(new Button("저장", MSFMainApp.ICONS.saveSmall(), new SelectionListener<ButtonEvent>() {   
      @Override  
      public void componentSelected(ButtonEvent ce) {   

    	  int panelSize = payr0520GridPanel.getMsfGrid().getStore().getModifiedRecords().size();
      	 
    	  if (panelSize <1) {
    		  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "데이타를 확인해 주세요.", null);
    	  }
    	  else {
    		  setListRecord(payr0520GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
    		  doAction(actionDatabase); 
    	  }
      }   
    }));   
     
     cpGridPayr0520.addButton(new Button("삭제", MSFMainApp.ICONS.deleteSmall(),new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {  
	          
	          Iterator<BaseModel> itBm  = payr0520GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
              
	          List<Record>  lsRec  = new ArrayList<Record>();
              
	          while(itBm.hasNext()) {
 
                  Record rec  = new Record(itBm.next()); 
                  lsRec.add(rec);
                  
              } 
               setListRecord(lsRec.iterator()); 
                
              actionDatabase = ActionDatabase.DELETE;
              doAction(actionDatabase);
	      }   
 	}));  
	    
	    lcTabFormLayer.add(cpGridPayr0520); 
	      
	    return lcTabFormLayer;
 } 

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
			// TODO Auto-generated method stub
	        formInit();
	    
			IColumnFilter filters = null;
			payr0520ToPayr3200GridPanel.getTableDef().setTableColumnFilters(filters);
			
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_02, SimpleColumnFilter.OPERATOR_EQUALS);
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
            payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_IN); 
             
          //20180305추가 
            payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
            
             String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
            // String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
            // payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
             String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
             payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
			//payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.allowNulls(srhPyspGrdeCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
           //payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
             payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
              
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("payItemCd", MSFSharedUtils.getSelectedComboValue(srhDducDivCd,"payDducCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			payr0520ToPayr3200GridPanel.getTableDef().addColumnFilter("dataStatus", MSFSharedUtils.getSelectedComboValue(dataStatus,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
//			System.out.println(">> "+MSFSharedUtils.getSelectedComboValue(srhDducDivCd,"payDducCd"));
			payr0520ToPayr3200GridPanel.reload();
		}
	  
	  
	 //폼초기화 검색조건포함 
	   private void formInit() { 
	      
           dpobCd.setValue("");
	       payItemCd.setValue("");    /** column 급여항목코드 : payItemCd */ 
           payItemNm.setValue("");    /** column 급여항목코드 : payItemCd */
	       pymtDducSum.setValue(0L);    /** column 지금공제금액 : pymtDducSum */
	       pymtDducRate.setValue(0.0);    /** column 지금공제율 : pymtDducRate */
	       pymtDducItemBgnnDt.reset();    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
	       pymtDducItemEndDt.reset();    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
	       
	       payr0520ToPayr3200GridPanel.getMsfGrid().clearData();
	       payr0520GridPanel.getMsfGrid().clearData();
	       
	       actionDatabase = ActionDatabase.UPDATE;
	      
	   }
		   
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Payr5400 getThis() {
		return this;
	}
	   
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/		   
	   
	   //부서 
//	   private void fnPopupCommP140(String deptCd) {
//	       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//	       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//	       //검색.처리하면됨.
//	       
//	       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//	       
//	       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//	      
//	       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//	           public void handleEvent(BaseEvent be) {
//	               BaseModel mapModel = (BaseModel)be.getSource();
//	               if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//	                    
//	                   srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//	                   srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//	                   srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//	                   srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//	                   srhDeptCd.fireEvent(Events.Add);
//	               }  
//	                    
//	           }
//	       });
//	   }

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
	                     
	                   
					BaseModel bmData = payr0520GridPanel.getTableDef().getDefaultValues(); 
					
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
                       
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
                           
						bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());						/** column 사업장코드 : dpobCd */  
                        bmData.set("systemkey",MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** column SYSTEMKEY : systemkey */    
//                        bmData.set("deptCd",MSFSharedUtils.allowNulls(bmMapModel.get("deptCd")));   		/** column 부서코드 : deptCd */ 
//                        bmData.set("deptNm",MSFSharedUtils.allowNulls(bmMapModel.get("deptNm")));   		/** column 부서 : deptNm */ 
                        bmData.set("deptCd",MSFSharedUtils.allowNulls(bmMapModel.get("currAffnDeptCd")));   		/** column 부서코드 : deptCd */ 
                        bmData.set("deptNm",MSFSharedUtils.allowNulls(bmMapModel.get("currAffnDeptNm")));   		/** column 부서 : deptNm */ 
                        
                        bmData.set("hanNm",MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));  			/** column 한글성명 : hanNm */ 
                        bmData.set("resnRegnNum",MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum"))); /** column 주민등록번호 : resnRegnNum */ 
                                   
                        bmData.set("payItemCd$payExtpyCd",MSFSharedUtils.allowNulls(payItemCd.getValue()));	/** column 급여항목코드 : payItemCd */ 
                        bmData.set("payItemNm$payExtpyNm", MSFSharedUtils.allowNulls(payItemNm.getValue()));/** column 급여항목코드 : payItemCd */
                        bmData.set("pymtDducItemSilNum",0L);    											/** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
                           
                        bmData.set("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_02);  						/** column 지급공제구분코드 : pymtDducDivCd */
                        bmData.set("pymtDducDivNm", "수당");  												/** column 지급공제구분 : pymtDducDivNm */
                           
                        bmData.set("pymtDducSum",0L);    													/** column 지금공제금액 : pymtDducSum */
                        bmData.set("pymtDducRate",0.0);    													/** column 지금공제율 : pymtDducRate */
                        bmData.set("pymtDducFreeDtySum",0L);    											/** column 지금공제비과세금액 : pymtDducFreeDtySum */
                          
                        bmData.set("pymtDducItemNoteCtnt","");    											/** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
                         //  bmData.set("pymtDducItemBgnnDt","");    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
                         //  bmData.set("pymtDducItemEndDt","");    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
                        bmData.set("pymtDducItemDelYn",false);    											/** column 지급공제항목삭제여부 : pymtDducItemDelYn */  
                            
                           	 
//                           kybdr.setValue(record.get("kybdr"));    /** column 입력자 : kybdr */
//                           inptDt.setValue(record.get("inptDt"));    /** column 입력일자 : inptDt */
//                           inptAddr.setValue(record.get("inptAddr"));    /** column 입력주소 : inptAddr */
//                           ismt.setValue(record.get("ismt"));    /** column 수정자 : ismt */
//                           revnDt.setValue(record.get("revnDt"));    /** column 수정일자 : revnDt */
//                           revnAddr.setValue(record.get("revnAddr"));    /** column 수정주소 : revnAddr */
					} 
                       
					payr0520GridPanel.getMsfGrid().getGrid().stopEditing();      
                    payr0520GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
                    payr0520GridPanel.getMsfGrid().getGrid().startEditing(payr0520GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
                    payr0520GridPanel.setSize(628, (320 - 19) );       // - cpGridPayr0520.getBottomComponent().getOffsetHeight())
                     
                    actionDatabase = ActionDatabase.INSERT; 
	                    
				}  
			}
		});
	}
	   
	/**
     * 지급공제선택 
     */
	private void fnPopupCommP500() {
       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
       //검색.처리하면됨.
		PrgmComP0500DTO sysComP0500Dto = new PrgmComP0500DTO();
       //지급공제구분코드 넘김.
       MSFFormPanel popCom0500 = PrgmComPopupUtils.lovPopUpPrgmCom0500Form(sysComP0500Dto);  //인사  
       
       final FormBinding popBindingCom0500 = popCom0500.getFormBinding();
      
       popBindingCom0500.addListener(Events.Change, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {
              
               List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
               
               if (mapModels != null) { 
                     
                   if (mapModels.size() > 1) {
                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                            "한건의 데이타만 선택가능합니다. 데이타를 확인하십시요.", null);
                       return;
                   }
                   
                   
//                   BaseModel bmData = payr0307GridPanel.getTableDef().getDefaultValues(); 
              
                   Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
                   while (iterRecords.hasNext()) {
                	   
                         BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
                         
                         payr0520Dto = new Payr0520DTO();
                         
                         payr0520Dto.setPayYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"year"));
                         payr0520Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd"))); 		/** column 급여항목코드 : payItemCd */ 
                         payr0520Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd"))); 	/** column null : pymtDducDivCd */
                           
                   }  
                   
                   xlsExportData(payr0520Dto);
//                   actionDatabase = ActionDatabase.INSERT; 
               	}
			}
		});
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	
	   
	   
	   
	
	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}
      
	private void setFormData() {

		dpobCd.setValue(MSFSharedUtils.allowNulls(record.get("dpobCd")));
		payItemCd.setValue(MSFSharedUtils.allowNulls(record.get("payItemCd")));		/** column 급여항목코드 : payItemCd */
		payItemNm.setValue(MSFSharedUtils.allowNulls(record.get("payItemNm")));		/** column 급여항목코드 : payItemCd */

	}
      
	private void setFormDataMapping() {
		
		payItemCd.setValue((String) record.get("payItemCd$payExtpyCd"));		/** column 공제코드 : pymtDducCd */
		payItemNm.setValue((String) record.get("payItemCd$payExtpyNm"));		/** column 공제명 : pymtDducNm */

		pymtDducSum.setValue((Long) record.get("pymtDducSum"));					/** column 지금공제금액 : pymtDducSum */
		pymtDducRate.setValue((Double) record.get("pymtDducRate"));				/** column 지금공제율 : pymtDducRate */
		pymtDducItemBgnnDt.setValue((Date) record.get("pymtDducItemBgnnDt"));	/** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
		pymtDducItemEndDt.setValue((Date) record.get("pymtDducItemEndDt"));		/** column 지급공제항목종료일자 : pymtDducItemEndDt */
         
	}
      
	private void gridDataReset() {
	      
		MessageBox.confirm("공제재설정", "현재 선택하신 그리드 로우을 기준으로 금액과일자를 재설정 합니다.\n 공제금액및일자를 재설정하시겠습니까?",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					if (payr0520GridPanel.getMsfGrid().getGrid().getStore().getCount() > 0) {
                    	  
						List<Record>  lsRec  = new ArrayList<Record>();
						for(int ilsCnt =0;ilsCnt < payr0520GridPanel.getMsfGrid().getGrid().getStore().getCount();ilsCnt++)  {
                               
                        	
                    	if (!(pymtDducSum.getValue().intValue() < 0)) {
                    		payr0520GridPanel.getMsfGrid().getGrid().getStore().getRecord(payr0520GridPanel.getMsfGrid().getGrid().getStore().getAt(ilsCnt)).set("pymtDducSum", pymtDducSum.getValue());    /** column 지금공제금액 : pymtDducSum */
                    	} 
                    	if (!(pymtDducRate.getValue().intValue() < 0)) {
                    		payr0520GridPanel.getMsfGrid().getGrid().getStore().getRecord(payr0520GridPanel.getMsfGrid().getGrid().getStore().getAt(ilsCnt)).set("pymtDducRate", pymtDducRate.getValue());    /** column 지금공제율 : pymtDducRate */
                    	} 
                              
                    	if (MSFSharedUtils.paramNotNull(pymtDducItemBgnnDt.getValue())) {
                    		payr0520GridPanel.getMsfGrid().getGrid().getStore().getRecord(payr0520GridPanel.getMsfGrid().getGrid().getStore().getAt(ilsCnt)).set("pymtDducItemBgnnDt", pymtDducItemBgnnDt.getValue());    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
                    	}
                    	
                    	if (MSFSharedUtils.paramNotNull(pymtDducItemEndDt.getValue())) {
                    		payr0520GridPanel.getMsfGrid().getGrid().getStore().getRecord(payr0520GridPanel.getMsfGrid().getGrid().getStore().getAt(ilsCnt)).set("pymtDducItemEndDt", pymtDducItemEndDt.getValue());    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
                    	}
                              
                            //  payr0520GridPanel.getMsfGrid().getGrid().getStore().update(payr0520GridPanel.getMsfGrid().getGrid().getStore().getAt(ilsCnt)); 
						}
					}  
				}
			}
		});
	}
	
	
	/** 엑셀 양식 다운 **/
	private void xlsExportData(Payr0520DTO payr0520Dto) {
		
		HashMap<String, String> param = new HashMap<String, String>(); 
        
		param.put("payYr", MSFSharedUtils.allowNulls(payr0520Dto.getPayYr()));					
		param.put("payItemCd", MSFSharedUtils.allowNulls(payr0520Dto.getPayItemCd()));			/** column 급여항목코드 : payItemCd */ 
		param.put("pymtDducDivCd", MSFSharedUtils.allowNulls(payr0520Dto.getPymtDducDivCd()));	/** column null : pymtDducDivCd */
		
		
	                           
		payr0520GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr5400TempExport.do","extgwtFrame" ,param);  
	           
	}
	
	/** 엑셀 업로드 **/
	private void xlsImportData() { 
		MessageBox.confirm("수당 생성", "개별 수당 내역을 생성하시겠습니까?</br> 이미 등록되어 있는 수당 내역은 삭제됩니다.",new Listener<MessageBoxEvent>(){
	      	@Override
	    	public void handleEvent(MessageBoxEvent be) {
	      		//if("Yes".equals(be.getButtonClicked().getText())){
	      		if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	      			
	      			HashMap<String, String> param = new HashMap<String, String>();
	      			
	      			// only accept certain files 
//	            	String year = PersonalUtil.getSelectedComboValue(creYear,"year");
//		            String name = MSFSharedUtils.allowNulls(srhHanNm.getValue());    
//		            String hodyBgnnDt = PersonalUtil.getConvertDateToString(creWorkDayS, "yyyyMMdd");
//		            String hodyEndDt = PersonalUtil.getConvertDateToString(creWorkDayE, "yyyyMMdd"); 
//		            String emymtDivCd = PersonalUtil.getSelectedComboValue(creEmymtDivCd,"commCd");
//		            String deptCd = PersonalUtil.getStrValToBMMultiCombo(lscrDeptCd,creDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//		            String typOccuCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
//		           // String pyspGrdeCd = PersonalUtil.getStrValToBMMultiCombo(lscrTypOccuCd,creTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//		            String dtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lscrDtilOccuInttnCd,creDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
//		            String businCd = PersonalUtil.getSelectedComboValue(creBusinCd, "businCd"); 
//		            String payrMangDeptCd = PersonalUtil.getSelectedComboValue(crePayrMangDeptCd,"payrMangDeptCd"); 
//		            String systemKey = MSFSharedUtils.allowNulls(systemkey.getValue()); 
	                  
	      			//get the filename to be uploaded
	      			String filename = MSFSharedUtils.allowNulls(payr5400flUp.getValue());
	      			if (filename.length() == 0) {
	      				Window.alert("선택된 파일이 없습니다.");
	             	} else {
	             		//submit the form
	             		plFrmPayr3200.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
	                            
	             		//파일업로드 처리
	             		plFrmPayr3200.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadPayr5400Import.do");
	             		plFrmPayr3200.setEncoding(Encoding.MULTIPART);
	             		plFrmPayr3200.setMethod(Method.POST);   
	             		plFrmPayr3200.submit();  
	             		plFrmPayr3200.onFrameLoad();  
	             		picBoolFile = true;
	             	}               
	      			// reset and unmask the form 
	      			// after file upload 
	      			plFrmPayr3200.addListener(Events.Submit, new Listener<FormEvent>() {
	      				public void handleEvent(FormEvent evt) {   
	      					if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	      						//업로드가  성공했으면 인서트 모듈을 태운다. 
	      						plFrmPayr3200.unmask();  
//	      						MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
	      						picBoolFile = false;
	      						evt.setResultHtml("");
	      						
//	      						MessageBox.alert("", "데이터를 재조회 해주세요..", null); 
	      						
	      						reload();
	      					} else {
	      						
	      						if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
	      							//업로드가  성공했으면 인서트 모듈을 태운다.
	      							MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
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
			}
		});
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
