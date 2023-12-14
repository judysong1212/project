/**
 * PayGenConst.PAYGEN_VERSION.concat("  - 인사기본출력
 */
package com.app.exterms.personal.client.form;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.form.defs.Psnl0100Def;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.client.service.Psnl0100ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 * ==================================================== 
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. 
 * extends MSFPanel -> extends LayoutContainer implements IMSFWindow { 
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Psnl0250 extends MSFPanel {
/**
 * ####################################################### 
 * { 시스템 기본설정파일 선언부 시작} 
 * #######################################################
 */
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  private boolean boolKeyCode = true;   //중복팝업에 의해 변경 
	 
/**
 * ####################################################### 
 * { 시스템 기본설정파일 선언부 종료} 
 * #######################################################
 */ 
	private VerticalPanel vp;
	private FormPanel plFrmPsnl0250; // formpanel
	private String txtForm = "";
	final TabPanel tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	public FormBinding formBinding;	//폼바인딩변수
	
	private BaseModel record;
    private Iterator<Record> records;
	
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topPsnl0250Bar;						//상위 버튼 Bar	
	private Button btnPsnl0250Reset;						//초기화 버튼
	private Button btnPsnl0250Sreach;						//조회 버튼
	private Button btnPsnl0250Print;						//인쇄 버튼
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 시작 --------------
	//private ComboBox<BaseModel> searchManageDeptCd; // 관리부서
	//private ComboBox<BaseModel> searchDeptCd; // 부서
	private HashMap<String, String> param = new HashMap<String, String>();
	private FieldSet fieldSet; 								//검색조건
	private TextField<String> searchName;					//이름
	private TextField<String> searchResnRegnNum; 			//주민번호
//	private ComboBox<BaseModel> searchTypOccuCd; 			//직종
	private ComboBox<BaseModel> srhDeptGpCd; 				//부서직종그룹코드	  
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종  
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;//직종세
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; 	//재직 
//	private TextField<String> srhDeptCd; 					//부서코드
	private MSFMultiComboBox<ModelData> srhDeptCd; 			//부서코드
    private TextField<String> srhDeptNm; 					//부서명  
    private Button btnSrhDeptCd;							//부서검색 버튼
    private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
	private ComboBox<BaseModel> srhPayrMangDeptCd;			//단위기관
	private ComboBox<BaseModel> srhBusinCd;    				//사업
	private HiddenField<String> srhSystemkey;   			//시스템키
	private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분 
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		//호봉제구분코드  
	// -------------- 검색조건 종료 --------------

	private Boolean emptyCheck = false ;

	
	private Grid<Psnl0100DTO> psnl0100Grid;
	private CheckBoxSelectionModel<Psnl0100DTO> sm;
	
	//직종콤보
//	private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	private MSFGridPanel typOccuCdGridPanel;
	
	
	// -------------- 서비스 호출 시작 --------------
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	//공통코드 호출
	//private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();	//부서코드 호출
	// -------------- 서비스 호출 종료 --------------
	
	// -------------- 출력조건 시작 --------------
	private RadioGroup outputTypeRadiogroup;
	// -------------- 출력조건 종료 --------------
	
	// -------------- listStore 선언 시작 --------------
//	private ListStore<BaseModel> listStoreBass0400All = new ListStore<BaseModel>(); // 소속부서 전체 데이타
//	private ListStore<BaseModel> listStoreBass0400 = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreA003 		= new ListStore<BaseModel>();	//재직구분
	private ListStore<BaseModel> listStoreA041 		= new ListStore<BaseModel>();	//직종
	private ListStore<BaseModel> listStoreA002 		= new ListStore<BaseModel>();	//고용구분
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();	//단위기관 
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서 
 
	private ListStore<BaseModel> lsDeptCd  			= new ListStore<BaseModel>();	//부서콤보
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();	//고용구분 
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();	//직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd  = new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();	//부서
	private ListStore<BaseModel> lsHdofcCodtnCd 	= new ListStore<BaseModel>(); 	//재직상태 
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  
	// -------------- listStore 선언 끝 --------------
	
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0150DTO sysComBass0150Dto;	//단위기관
	private PrgmComBass0300DTO sysComBass0300Dto; 	//공통코드 
	private PrgmComBass0350DTO sysComBass0350Dto;  	//직종세
	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드 
	private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- DTO 선언 끝 ---------------
	
	
	// -------------- List<ModelData> 선언 시작 ---------------
	private boolean mutilCombo = false;
	
	private List<ModelData> mDtalistHdofcCodtnCd;
    private List<ModelData> mDtalistDeptCd;
    private List<ModelData> mDtalistTypOccuCd;
    private List<ModelData> mDtalistDtilOccuInttnCd;
    // -------------- List<ModelData> 선언 끝  ---------------
    
 // -------------- grid 선언 시작  ---------------
 	private Psnl0100Def psnl0100Def  = new Psnl0100Def();   //그리드 테이블 컬럼 define  
 	private MSFGridPanel psnl0100GridPanel;
 	// -------------- grid 선언 종료  ---------------
    
    // -------------- HiddenField 선언 시작 ------------------
    private HiddenField<String> payrMangDeptCd;		//단위기관 
    private HiddenField<String> typOccuCd;          //직종코드 
    private HiddenField<String> dtilOccuInttnCd;   //직종세구분코드
    private HiddenField<String> currAffnDeptCd;     //현소속부서코드 
    private HiddenField<String> businCd;            //사업코드 
    // -------------- HiddenField 선언 끝 ------------------
    
	
	private Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	
//	private RpcProxy<BaseListLoadResult<Psnl0100DTO>> psnl0100Proxy = new RpcProxy<BaseListLoadResult<Psnl0100DTO>>() {
//
//		@Override
//		protected void load(Object loadConfig,
//				AsyncCallback<BaseListLoadResult<Psnl0100DTO>> callback) {
//			// TODO Auto-generated method stub
//			//param.put("searchMangeDeptCd", PersonalUtil.getSelectedComboValue(searchManageDeptCd,"mangeDeptCd") ); //관리부서
//			//param.put("searchDeptCd", PersonalUtil.getSelectedComboValue(searchDeptCd,"deptCd") ); //관리부서
////			param.put("type", "search");
////			param.put("searchName", searchName.getValue()); //성명
////			param.put("searchResnRegnNum", searchResnRegnNum.getValue()); //주민번호
////			param.put("searchHdofcCodtnCd",PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd) ); //재직구분
////			
////			param.put("searchDeptCd", srhDeptCd.getValue() ); //관리부서
////			param.put("searchTypOccuCd",PersonalUtil.getSelectedComboValue(searchTypOccuCd)); //직종
////			param.put("searchEmymtDivCd",PersonalUtil.getSelectedComboValue(searchEmymtDivCd));
////			param.put("searchBusinCd",PersonalUtil.getSelectedComboValue(searchYearBusinCd,"businCd"));
//			param.put("type", "search");
//			param.put("srhPayrMangDeptCd", PersonalUtil.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));	//단위기관
//		    String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
//			   if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
//	    	           String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
//	    	           String chkkey = "";
//	    	           for (int i=0; i<ray.length; i++){ 
//	    	               BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
//	    	               chkkey += bmData.get("commCd")+","; 
//	    	           }
//	    	           strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
//			   } 
//			
//			param.put("searchHdofcCodtnCd", strHdofcCodtnCd);								//재직
//			param.put("srhEmymtDivCd", PersonalUtil.getSelectedComboValue(srhEmymtDivCd));	//고용구분
//			param.put("searchName", searchName.getValue()); 								//성명
//			param.put("searchResnRegnNum", searchResnRegnNum.getValue()); 					//주민번호('-' 제거 해야만 검색가능)
//			param.put("srhDeptCd", PersonalUtil.getStrValToBMMultiCombo(
//					lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));				//부서
//			param.put("srhTypOccuCd", PersonalUtil.getStrValToBMMultiCombo(
//					lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));		//직종
//			param.put("srhDtilOccuInttnCd", PersonalUtil.getStrValToBMMultiCombo(
//					lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));	//직종세
//			param.put("srhBusinCd", PersonalUtil.getSelectedComboValue(srhBusinCd,"businCd"));				//사업
//			
//			try{
//				psnl0100Service.selectPsnl0100((BaseListLoadConfig) loadConfig,	param, callback);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//			param = new HashMap<String, String>();
//		}
//	};
//	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0110Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0100Proxy);
//	private ListStore<Psnl0100DTO> psnl0100Store = new ListStore<Psnl0100DTO>(psnl0110Loader);
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

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
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * Print 인쇄 선언부 변수 선언부 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */		

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
		  private void checkPsnl0250Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
				    //----------------------------------------------------
				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
				   
	                 
			   }
		  }
		  
		  private void authExecEnabled() { 
			   //------------------
			  Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
              
			   gwtAuthorization.formAuthFieldConfig(fldArrField);
			   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			   
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
                // GWTAuthorization.formAuthPopConfig(plFrmPayr4100, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
                // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
                // GWTAuthorization.formAuthConfig(plFrmPayr4100, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
			     //gwtAuthorization.formAuthConfig(plFrmPsnl0250, "srhPsnlMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
               /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                * 권한설정을 위한 콤보처리를 위한 메서드 종료
                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
               srhDeptCd.getListView().fireEvent(Events.CheckChanged);
            
			 }
		  
//		  private AuthAction authAction;
//		  private int checkCntDef = 4;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkPsnl0250Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			 
//			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//			   
//				  
//	                 
//	                //----------------------------------------------------
//	                unmask(); 
//	                //MSFMainApp.unmaskMainPage();
//	                 
//			   }
//		  }

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
			     
			  authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
		      authMapDef.put("srhEmymtDivCd",Boolean.FALSE); 
			  authMapDef.put("srhDeptCd",Boolean.FALSE);
			  //authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
				 
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
	  
		  
	// @Override
	// protected void onRender(Element parent, int index) {
	// super.onRender(parent, index);
	//
	// // formData = new FormData("-650");
	// vp = new VerticalPanel();
	// vp.setSpacing(10);
	// createPsnl0250Form(); //화면 기본정보를 설정
	// createSearchForm(); //검색필드를 적용
	// createCheckBoxGrid(); //기본정보필드
	// add(vp);
	// vp.setSize("1010px", "700px");
	// }

	public ContentPanel getViewPanel() {
		if (panel == null) {

			initLoad();
			
			//listStoreBass0400 = PrgmComComboUtils.getMangDeptBass0400ComboData(new PrgmComBass0400DTO());
//			sysComBass0400Service.getPrgmComDeptBass0400List(new PrgmComBass0400DTO(),new AsyncCallback<List<BaseModel>>() {
//				@Override
//				public void onSuccess(List<BaseModel> result) {
//					listStoreBass0400All.add(result);
//				}
//				@Override
//				public void onFailure(Throwable caught) {
//					caught.printStackTrace();
//				}
//			});
			
//			List<String> arrRpsttvCd = new ArrayList<String>();
//			arrRpsttvCd.add("A002"); //고용구분
//			arrRpsttvCd.add("A003"); //재직구분
//			arrRpsttvCd.add("A041"); //직종
//			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
//			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
//			
//			// 공통 코드 가져오기
//			sysComBass0300Service.getPrgmComMultiComboBass0300List(
//					sysComBass0300Dto,
//					new AsyncCallback<HashMap<String, List<BaseModel>>>() {
//
//						@Override
//						public void onSuccess(
//								HashMap<String, List<BaseModel>> result) {
//							// TODO Auto-generated method stub
//							if (result != null && result.size() > 0) {
//								listStoreA041.add(result.get("A041"));
//								listStoreA003.add(result.get("A003"));
//								listStoreA002.add(result.get("A002"));
//								
//								searchHdofcCodtnCd.setValue(listStoreA003.getAt(0));
//								
//							}
//						}
//
//						@Override
//						public void onFailure(Throwable caught) {
//							// TODO Auto-generated method stub
//							MessageBox.alert("", "공통코드 에러!", null);
//						}
//
//					});

		//	detailTp = XTemplate.create(getDetailTemplate());
			vp = new VerticalPanel();
			vp.setSize("1010px", "700px");
			// vp.setSpacing(10);

			createPsnl0250Form();	// 화면 기본정보를 설정
			createSearchForm();		// 검색필드를 적용
			createCheckBoxGrid(); 	// 기본정보필드
			createListGrdForm();	// 그리드

			

			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmPsnl0250, true);

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
	 * @wbp.parser.constructor
	 */
	public Psnl0250() {
		setSize("1010px", "700px");
	}

	public Psnl0250(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0250Form() {

		plFrmPsnl0250 = new FormPanel();
		plFrmPsnl0250.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 인사기본출력"));
		plFrmPsnl0250.setIcon(MSFMainApp.ICONS.text());
		plFrmPsnl0250.setBodyStyleName("pad-text");
		plFrmPsnl0250.setFrame(true);
		plFrmPsnl0250.setPadding(2);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("인사기본출력","PSNL0250");
				}
			});
		plFrmPsnl0250.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0250.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		topPsnl0250Bar = new ButtonBar();
		topPsnl0250Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnPsnl0250Reset = new Button("초기화");
		btnPsnl0250Reset.setIcon(MSFMainApp.ICONS.new16());
		btnPsnl0250Reset.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				searchInit();	//검색조건 초기화
			}
		});
		topPsnl0250Bar.add(btnPsnl0250Reset);


		btnPsnl0250Sreach = new Button("조회");
		btnPsnl0250Sreach.setIcon(MSFMainApp.ICONS.search16());
		btnPsnl0250Sreach.addListener(Events.Select, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				// TODO Auto-generated method stub
				//psnl0110Loader.load();
				reload();
			}
		});
		topPsnl0250Bar.add(btnPsnl0250Sreach);

		btnPsnl0250Print = new Button("인쇄", psnl0250ButtonListener);
		btnPsnl0250Print.setIcon(MSFMainApp.ICONS.print16());
		topPsnl0250Bar.add(btnPsnl0250Print);

		plFrmPsnl0250.add(topPsnl0250Bar);

		vp.add(plFrmPsnl0250);
		plFrmPsnl0250.setSize("990px", "690px");
	}

	private SelectionListener<ButtonEvent> psnl0250ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			String printType = PersonalUtil.getCheckedRadioValue(outputTypeRadiogroup);
			if("temp".equals(printType)){
				//출근부 추후 작성
				Window.alert("준비중입니다.");
			}else {
				Psnl0250Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
//			Psn0250Print(printType);
			
//			RexPrint(printType);
			//RdaPrint(printType);
		}
	};

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	print Service 선언부 시작
     *  rex 추가로 리포트 타입변경
     *  fileName : 출력파일명 
     *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
	private void Psnl0250Print(String fileName, String repType) {
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    }	
	
//	//rda
//	private void RdaPrint(String fileName) {
//		
//		// 출력물 디렉토리 패스경로 인사 : PSNL
////		String strDirPath = "PSNL";
//		strDirPath = new String();
//		strDirPath = "PSNL";
//		
//		// mrd 출력물
////		String rdaFileName = fileName+".mrd";
//		rdaFileName = new String();
//		rdaFileName = fileName+".mrd";
//		
//		// 보낼 파라미터
//		
////		String strParam="";
//		strParam = new String();
//		strParam = "";
//		
//		//검색조건
////		String serarchParam = "";
//		serarchParam = new String();
//		serarchParam = "";
//		
//		
//		serarchParam += "["+MSFSharedUtils.allowNulls(searchName.getValue())+"]";					//$1 성명
//		serarchParam += "["+MSFSharedUtils.allowNulls(searchResnRegnNum.getValue())+"]";				//$2 주민등록번호
//		serarchParam += "["+PersonalUtil.getPrintStrToMultiData(lsHdofcCodtnCd, srhHdofcCodtnCd.getValue(), "commCdNm", "commCd")+"]";	//$3 재직구분
//		serarchParam += "["+MSFSharedUtils.allowNulls(srhDeptCd.getValue())+"]";		//$4 소속부서
//		serarchParam += "["+PersonalUtil.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd") +"]";    //$5 현부서
//		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";		//$6 고용구분
//		serarchParam += "["+PersonalUtil.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";  //$7 직종
//		serarchParam += "["+MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd"))+"]"; //$8
//        serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";		//$9 시스템키 
//		
////		String checkedSystemKeys = "";
//		checkedSystemKeys = new String();
//		checkedSystemKeys = "";
//		int keyCnt = 0;
//		
//		
//		
//		List<BaseModel> list = psnl0100GridPanel.getGrid().getSelectionModel().getSelectedItems();
//        if(list != null && list.size() > 0){
//            String chkkey = "";
//            int iCnt = 0;
//            for(BaseModel bm : list){
//            	
//                chkkey += "'"+bm.get("systemkey")+"',";
//                
//                iCnt = iCnt + 1;
//            }
//            
//            keyCnt = iCnt;
//            	
//            checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
//        }
//		
//      		
//        //도장 출력을 위해 추가 2014-11-06 //$10
//      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
//      		if(MSFSharedUtils.paramNull(myImgUrl)) {
//      			// myImgUrl = "http://105.19.10.32:8080";
//              	//경로오류 출력 
//      	}
//      		
//        //TODO 검색 후 결국엔 시스템키만 넘김..?
//		//검색조건 데이터 안넘기도록 변경 2014.09.16
//		if("PSNLT0250".equals(fileName) ){
////			serarchParam = "['']['']['']['']['']['']['']['']";
//			
////			String strParam = "" + serarchParam +"⊥";
////			serarchParam = "[''][''][''][''][''][''][]";
//			
//			if(keyCnt < 200) {
//				serarchParam = "[][][][][][][][]";
//				
//				strParam = "/rp " + serarchParam + "[" + checkedSystemKeys + "]";
//			}else {
//				MessageBox.confirm("출력", "200건 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
//					@Override
//					public void handleEvent(MessageBoxEvent be) {
//						// TODO Auto-generated method stub
//						
//						if("Yes".equals(be.getButtonClicked().getText())){
//							strParam = "/rp " + serarchParam;
//						}else {
//							strParam = "/rp " + serarchParam + "[" + checkedSystemKeys + "]";
//						}
//					}
//				});
//			}
////			strParam = "/rp " + serarchParam + "[" + checkedSystemKeys + "]";
//		}else if("PSNLT0251".equals(fileName)|| "PSNLT0257".equals(fileName)) {
//			serarchParam = "[][][][][][][][]";
//			strParam = "/rp " + serarchParam + "[" + checkedSystemKeys + "]";
//		}else{
//			
//			serarchParam = "[][][][][][][][]";
////			String strParam = "" + serarchParam + "" + checkedSystemKeys + "⊥"  + myImgUrl;
////			serarchParam = "[][][][][][][]";
//			
////			System.out.println("파라미터 테스트 " + strParam);
//			strParam = "/rp " + serarchParam + "[" + checkedSystemKeys + "]"  + "[" + myImgUrl + "]";
//		}
//				
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//	}
	//rda
	private void RdaPrint(final String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		strDirPath = new String();
		strDirPath = "PSNL";
		
		// mrd 출력물
		rdaFileName = new String();
		rdaFileName = fileName+".mrd";
		
		
		// 보낼 파라미터
		strParam = new String();
		strParam = "";
		
		//검색조건
		serarchParam = new String();
		serarchParam = "";
		
        
		//권한 설정으로 인해 추가된 부분 
        String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
        final String deptCdAuth = MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
        final String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
        
        
		serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";			//$1 사업장코드
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$2 단위기관
		serarchParam += "["+MSFSharedUtils.allowNulls(PersonalUtil.getPrintStrToMultiData(lsHdofcCodtnCd, MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue()), "commCdNm", "commCd"))+"]";	//$3 재직구분
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";		//$4 고용구분
		serarchParam += "["+MSFSharedUtils.allowNulls(searchName.getValue())+"]";					//$5 성명
		serarchParam += "["+"]";																	//$6 주민등록번호
		 //20151212-추가 시작 
	    if (payrMangDeptCd.equals(deptCdAuth)) { 
	    	serarchParam += "[]"; //$7 부서
        } else {
        	serarchParam += "["+ PersonalUtil.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$7 부서
        }  
	    //20151212-추가 끝
		
		serarchParam += "["+PersonalUtil.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";  //$8 직종
		serarchParam += "["+PersonalUtil.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")+"]"; //$9 직종세
        
		
		checkedSystemKeys = new String();
		checkedSystemKeys = "";
		int keyCnt = 0;
		
		
		List<BaseModel> list = psnl0100GridPanel.getGrid().getSelectionModel().getSelectedItems();
		
        if(list != null && list.size() > 0){
            String chkkey = "";
            int iCnt = 0;
            
            for(BaseModel bm : list){
                chkkey += "'"+bm.get("systemkey")+"',";
                iCnt = iCnt + 1;
            }
            keyCnt = iCnt;
            checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); //$10 시스템키   
            
        }else if(list == null || list.size() <= 0){
        	MessageBox.info("알림", "출력대상자정보를 선택해주세요.", null);
      		return;
        }
		
      		
        //도장 출력을 위해 추가 2014-11-06 //$11 이미지 
      	final String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
      		if(MSFSharedUtils.paramNull(myImgUrl)) {
      			// myImgUrl = "http://105.19.10.32:8080";
              	//경로오류 출력 
      	}
      		
      		
      	//시스템키는 넘기지 않고 검색조건만 넘김	
      	if(keyCnt > 200) {
      		MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					// TODO Auto-generated method stub
					
					
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						
						//근로계약서
						if("PSNLT0250".equals(fileName)) {
							serarchParam +=  "[]" + "[]";
						//서약서, 휴직자명부	
						}else if("PSNLT0251".equals(fileName)|| "PSNLT0257".equals(fileName)) {
							serarchParam += "[]"  + "[]";
						//신상카드, 인사기록요약서, 인사카드, 사진명부
						}else {
							serarchParam += "[]" + "[" + myImgUrl + "]";
						}
						
						//20151212-변경추가 시작 
						serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //$12 유저ID
						serarchParam += "[" + MSFMainApp.get().getUser().getPayrMangDeptYn() + "]"; //$13 단위기관 여부
						  
						//권한처리를위해 넘기는 변수 2개추가 
						serarchParam += "[" + deptCdAuth + "]"; //$14 부서 권한
						serarchParam += "[" + dtilOccuInttnCdAuth + "]"; //$15 직종세 권한
						//20151212-추가 끝 
						
						strParam = "/rp " + serarchParam;
						
						//GWT 타입으로 팝업 호출시  postCall true 설정
						PrintUtils.setPostCall(true);
						PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
					}else {
						return;
					}
				}
			});
      	//선택한 시스템키 넘김
      	}else {
      		
      		//근로계약서
			if("PSNLT0250".equals(fileName)) {
				serarchParam += "[" + checkedSystemKeys +  "]" + "[" + "]";
			}else if("PSNLT0251".equals(fileName)|| "PSNLT0257".equals(fileName)) {
				serarchParam += "[" + checkedSystemKeys + "]" + "[]";
			}else {
				serarchParam += "[" + checkedSystemKeys + "]" + "[" + myImgUrl + "]";
			}
			
			//20151212-변경추가 시작 
			serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //$12 유저ID
			serarchParam += "[" + MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$13 단위기관 여부
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "[" + deptCdAuth + "]"; //$14 부서 권한
			serarchParam += "[" + dtilOccuInttnCdAuth + "]"; //$15 직종세 권한
			//20151212-추가 끝 
			
			strParam = "/rp " + serarchParam;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
      	}
	}
	
	//rex
	private void RexPrint(final String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		strDirPath = new String();
		strDirPath = "PSNL";
		
		// rex 출력물
		rexFileName = new String();
		rexFileName = fileName+".crf";
		
		// 보낼 파라미터
		strParam = new String();
		strParam = "";
		
		//검색조건
		serarchParam = new String();
		serarchParam = "";
		
        
		//권한 설정으로 인해 추가된 부분 
        String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
        final String deptCdAuth = MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
        final String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
        String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
        
		serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			//$1 사업장코드
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";   	//$2 단위기관
		serarchParam += ""+MSFSharedUtils.allowNulls(PersonalUtil.getPrintStrToMultiData(lsHdofcCodtnCd, MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue()), "commCdNm", "commCd"))+"⊥";	//$3 재직구분
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";				//$4 고용구분
		serarchParam += ""+MSFSharedUtils.allowNulls(searchName.getValue())+"⊥";							//$5 성명
		serarchParam += ""+"⊥";						//$6 주민등록번호
		 //20151212-추가 시작 
	    if (payrMangDeptCd.equals(deptCdAuth)) { 
	    	serarchParam += "⊥"; //$7 부서
        } else {
        	serarchParam += ""+ PersonalUtil.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; //$7 부서
        }  
	    //20151212-추가 끝
		
		serarchParam += ""+PersonalUtil.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  //$8 직종
		serarchParam += ""+MSFSharedUtils.allowNulls(PersonalUtil.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd"))+"⊥"; //$9 직종세
        
		
		checkedSystemKeys = new String();
		checkedSystemKeys = "";
		int keyCnt = 0;
		
		
		
		List<BaseModel> list = psnl0100GridPanel.getGrid().getSelectionModel().getSelectedItems();
		
        if(list != null && list.size() > 0){
            String chkkey = "";
            int iCnt = 0;
            
            for(BaseModel bm : list){
                chkkey += "'"+bm.get("systemkey")+"',";
                iCnt = iCnt + 1;
            }
            keyCnt = iCnt;
            checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); //$10 시스템키   
            
        }else if(list == null || list.size() <= 0){
        	MessageBox.info("알림", "출력대상자정보를 선택해주세요.", null);
      		return;
        }
		
      		
        //도장 출력을 위해 추가 2014-11-06 //$11 이미지 
      	final String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
      		if(MSFSharedUtils.paramNull(myImgUrl)) {
      			// myImgUrl = "http://105.19.10.32:8080";
              	//경로오류 출력 
      	}
      		

      	//시스템키는 넘기지 않고 검색조건만 넘김	
      	if(keyCnt > 200) {
      		MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					// TODO Auto-generated method stub
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						
						//근로계약서
						if("PSNLT0250".equals(fileName)) {
							strParam = "" + "⊥" + serarchParam + "" + "⊥" + "" + "⊥";
						//서약서, 휴직자명부	
						}else if("PSNLT0251".equals(fileName)|| "PSNLT0257".equals(fileName)) {
							strParam = serarchParam + "" + "⊥"  + "" + "⊥";
						//신상카드, 인사기록요약서, 인사카드, 사진명부
						}else {
							strParam = serarchParam + "" + "⊥" + "" + myImgUrl + "⊥";
						}
						
						//20151212-변경추가 시작 
						strParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  //$12 유저ID
						strParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn() + "⊥"; //$13 단위기관 여부
						  
						//권한처리를위해 넘기는 변수 2개추가 
						strParam += "" + deptCdAuth + "⊥"; //$14 부서 권한
						strParam += "" + dtilOccuInttnCdAuth + "⊥"; //$15 직종세 권한
						//20151212-추가 끝 
						
						
						//GWT 타입으로 팝업 호출시  postCall true 설정
						PrintUtils.setPostCall(true);
						PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
					}else {
						return;
					}
				}
			});
      	//선택한 시스템키 넘김
      	}else {
      		
      		//근로계약서
			if("PSNLT0250".equals(fileName)) {
				strParam += serarchParam + "" + checkedSystemKeys+ "⊥" + "" + "⊥";
			}else if("PSNLT0251".equals(fileName)|| "PSNLT0257".equals(fileName)) {
				strParam += serarchParam + "" + checkedSystemKeys + "⊥" + "" + "⊥";
			}else {
				strParam += serarchParam + "" + checkedSystemKeys + "⊥" + "" + myImgUrl + "⊥";
			}
			
			//20151212-변경추가 시작 
			strParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  //$12 유저ID
			strParam += "" + MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$13 단위기관 여부
			  
			//권한처리를위해 넘기는 변수 2개추가 
			strParam += "" + deptCdAuth + "⊥"; //$14 부서 권한
			strParam += "" + dtilOccuInttnCdAuth + "⊥"; //$15 직종세 권한
			//20151212-추가 끝 
			
			serarchParam += ""+mangeDeptCd+"⊥"; //parameter16
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
      	}
	}	
	
//	//rex 
//	private void RexPrint(String fileName) {
//		
//		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
////		String strDirPath = "PSNL";
//		strDirPath = new String();
//		strDirPath = "PSNL";
//		
//		
//		// reb 출력물
//		String rexFileName = fileName+".reb";
////		String rexFileName = fileName+".crf";
//		rexFileName = new String();
//		
//		// 보낼 파라미터  
//		
//        // 검색조건
//     	String serarchParam = "";
//     	
//     	String strParam="";
//     	
//		serarchParam += ""+MSFSharedUtils.allowNulls(searchName.getValue())+"⊥";					//$1 성명
//		serarchParam += ""+MSFSharedUtils.allowNulls(searchResnRegnNum.getValue())+"⊥";				//$2 주민등록번호
//		serarchParam += ""+PersonalUtil.getPrintStrToMultiData(lsHdofcCodtnCd, srhHdofcCodtnCd.getValue(), "commCdNm", "commCd")+"⊥";	//$3 재직구분
//		serarchParam += ""+MSFSharedUtils.allowNulls(srhDeptCd.getValue())+"⊥";		//$4 소속부서
//		serarchParam += ""+PersonalUtil.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd") +"⊥";    //$5 현부서
//		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";		//$6 고용구분
//		serarchParam += ""+PersonalUtil.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";  //$7 직종
//		serarchParam += ""+PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")+"⊥"; 	//$8 직종세
//        serarchParam += ""+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"⊥";		//$9 시스템키 
//        
//        //도장 출력을 위해 추가 2014-11-06 //$10
//      	String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
//      		if(MSFSharedUtils.paramNull(myImgUrl)) {
//      			// myImgUrl = "http://105.19.10.32:8080";
//              	//경로오류 출력 
//      	}
//      		
//    		String checkedSystemKeys = "";
//    		
//    		List<BaseModel> list = psnl0100GridPanel.getGrid().getSelectionModel().getSelectedItems();
//            if(list != null && list.size() > 0){
//                String chkkey = "";
//                for(BaseModel bm : list){
//                    chkkey += "'"+bm.get("systemkey")+"',";
//                }
//                
//                checkedSystemKeys = chkkey.substring(0,chkkey.length()-1); 
//            } 
//            
//        //TODO 검색 후 결국엔 시스템키만 넘김..?
//		//검색조건 데이터 안넘기도록 변경 2014.09.16
//		if("PSNLT0250".equals(fileName) ){
//			
////			serarchParam = "''⊥''⊥''⊥''⊥''⊥''⊥''⊥''⊥";
//			
////			serarchParam = "" + "⊥" + "" + "⊥" + "" + "⊥"+ "" + "⊥"+ "" + "⊥"+ "" + "⊥"+ "" + "⊥"+ "" + "⊥";
//			serarchParam = "⊥⊥⊥⊥⊥⊥⊥⊥⊥";
////			serarchParam = "⊥⊥⊥⊥⊥⊥⊥⊥⊥";
////			String strParam = "" + serarchParam +"⊥";
////			serarchParam = "[''][''][''][''][''][''][]";
////			strParam = "" + serarchParam + "" + checkedSystemKeys + "⊥";
//			strParam =  "" + "⊥" + serarchParam + "" + checkedSystemKeys + "⊥";
//		}else if("PSNLT0251".equals(fileName)|| "PSNLT0257".equals(fileName)) {
//			serarchParam = "⊥⊥⊥⊥⊥⊥⊥⊥⊥";
//			strParam = "" + serarchParam + "" + checkedSystemKeys + "⊥";
//		}else{
//			
//			serarchParam = "⊥⊥⊥⊥⊥⊥⊥⊥⊥";
////			String strParam = "" + serarchParam + "" + checkedSystemKeys + "⊥"  + myImgUrl;
////			serarchParam = "[][][][][][][]";
//			strParam = "" + serarchParam + "" + checkedSystemKeys + "⊥"  + "" + myImgUrl + "⊥";
//		}
////		strParam = "" + serarchParam + "" + checkedSystemKeys + "⊥"  + myImgUrl;
//						
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
//	}
	
//	private void Psn0250Print(String fileName) {
//
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PSNL";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		
//		// 보낼 파라미터
//		//검색조건
//		String serarchParam = "";
//		
//		String name = searchName.getValue() == null ? "" : searchName.getValue();
//		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
//		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
//		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
//		//String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
//		String deptCd = MSFSharedUtils.allowNulls(srhDeptCd.getValue());//소속부서
//		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
//		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
//		
//		serarchParam += "["+name+"]";
//		//serarchParam += "[]"; //한글깨짐을 위해 잠시 보류했었음
//		serarchParam += "["+resn+"]";
//		serarchParam += "["+hdofcCodtnCd+"]";
//		serarchParam += "[]";
//		//serarchParam += "["+manageDeptCd+"]";
//		serarchParam += "["+deptCd+"]";
//		serarchParam += "["+emymtDivCd+"]";
//		serarchParam += "["+typOccuCd+"]";
//		
//		List<Psnl0100DTO> list = sm.getSelectedItems();
//		String checkedSystemKeys = "";
//		if(list != null && list.size() > 0){
//			String chkkey = "";
//			for(Psnl0100DTO dto : list){
//				chkkey += "'"+dto.getSystemkey()+"',";
//			}
//			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//		}
//		
//		//검색조건 데이터 안넘기도록 변경 2014.09.16
//		if("PSNLT0250".equals(fileName)){
//			serarchParam = "[''][''][''][''][''][''][]";
//		}else{
//			serarchParam = "[][][][][][][]";
//		}
//		
//		String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//		
//		System.out.println(strParam);
//		
//		//String strParam = "/rp " + "[" + "20080311" + "]";
//		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//	}
	
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	
	/**
	 * 검색필드 설정
	 */
	private void createSearchForm() {
		
		srhSystemkey = new HiddenField<String>();		//시스템키 
		
		sysComBass0150Dto = new PrgmComBass0150DTO();	//단위기관
		sysComBass0300Dto = new PrgmComBass0300DTO();	//공통코드
		sysComBass0320Dto = new PrgmComBass0320DTO();	//직종코드
		sysComBass0350Dto = new PrgmComBass0350DTO();	//직종세
		sysComBass0400Dto = new PrgmComBass0400DTO();	//부서코드
		sysComBass0500Dto = new PrgmComBass0500DTO();	//사업코드  
		
		 
//		List<String> arrRpsttvCd = new ArrayList<String>();
//		arrRpsttvCd.add("A002"); //고용구분
//		arrRpsttvCd.add("A003"); //재직구분
//		//arrRpsttvCd.add("A041"); //직종
//		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
//		sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
//		
		//--------------------공통코드 가져옴 ------------------------------------------------
//		sysComBass0300Service.getPrgmComMultiComboBass0300List(
//				sysComBass0300Dto,
//				new AsyncCallback<HashMap<String, List<BaseModel>>>() {
//					@Override
//					public void onSuccess(
//							HashMap<String, List<BaseModel>> result) {
//						// TODO Auto-generated method stub
//						if (result != null && result.size() > 0) {
//							listStoreA041.add(result.get("A041"));	//직종
//							listStoreA003.add(result.get("A003"));	//재직구분
//							listStoreA002.add(result.get("A002"));	//고용구분
//							
//							searchHdofcCodtnCd.setValue(listStoreA003.getAt(0));
//						}
//					}
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						MessageBox.alert("", "공통코드 에러!", null);
//					}
//				});
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 
		 //재직상태  
		 sysComBass0300Dto.setRpsttvCd("A003");
		 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
             public void handleEvent(StoreEvent<BaseModel> be) {  
                 mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
                 srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
             }
		 });   
		 
		// 호봉코드
		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통코드 가져옴 -----------------------------------------------------
		
		 
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
		
		 //-------------------관리부서 추가  
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		 lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		 
	 
		 //--------------------부서 불러 오는 함수 ------------------------------------------------  
		 sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		 sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		
		 lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		
		 lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
             public void handleEvent(StoreEvent<BaseModel> be) {  
                 mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
                 srhDeptCd.getInitStore().add(mDtalistDeptCd);
             }
         });     
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		 
		 //---------------------직종 콤보 처리----------------------------------------------------
//		 ContentPanel typOccuCdGrid = new ContentPanel();  
//		 typOccuCdGrid.setVisible(false);
//		    
//		 typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		 typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//			 public void handleEvent(ComponentEvent be) {  
//				 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//					 public void handleEvent(StoreEvent<BaseModel> be) {  
//						 lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());  
//						 mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//						 srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//					 }  
//				 });  
//			 }  
//		 });  
//	    typOccuCdGrid.add(typOccuCdGridPanel); 
//		plFrmPsnl0250.add(typOccuCdGrid);
		 
		  lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		  lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
			  public void handleEvent(StoreEvent<BaseModel> be) {  
				  mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
				  srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			  }
		  });  
		  //---------------------직종 콤보 처리----------------------------------------------------
		
		  //---------------------멀티콤보박스 닫기 -------------------------------------------------
		  plFrmPsnl0250.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			  @Override
			  public void handleEvent(ComponentEvent ce) { 
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
					  } else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
						  //직종세
						  srhDtilOccuInttnCd.showClose(ce);
						  mutilCombo = false;
					  }  
				  }
			  } 
		  });
        //---------------------멀티콤보박스 닫기 -------------------------------------------------
		// FormPanel panel = new FormPanel();
		// panel.setFrame(true);
		// panel.setHeaderVisible(false);
		// panel.setIcon(MSFMainApp.ICONS.form());
		// panel.setHeadingText("FormPanel");
		// panel.setSize(600, -1);
		// panel.setLabelAlign(LabelAlign.TOP);
		// panel.setButtonAlign(HorizontalAlignment.CENTER);

		// FormPanel form2 = new FormPanel();
		// form2.setFrame(true);
		// form2.setHeadingHtml("Simple Form with FieldSets");
		// form2.setWidth(350);
		plFrmPsnl0250.setLayout(new FlowLayout());

		//lcSchCol.setLayout(new ColumnLayout());

		fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		// fieldSet.setCheckboxToggle(false);
		
		LayoutContainer lcSchCol = new LayoutContainer();
		
		
		//lcSchCol.add(lcSch1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		//lcSchCol.add(lcSch2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		LayoutContainer lcSch1 = new LayoutContainer();
		lcSch1.setLayout(new ColumnLayout());
		
		
		LayoutContainer lcSch1_1 = new LayoutContainer();
		FormLayout frmlytSch1_1 = new FormLayout();
		frmlytSch1_1.setLabelWidth(60);
		frmlytSch1_1.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSch1_1.setLayout(frmlytSch1_1);
		
		srhPayrMangDeptCd = new ComboBox<BaseModel>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setForceSelection(true);
		srhPayrMangDeptCd.setMinChars(1);
		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		srhPayrMangDeptCd.setSelectOnFocus(true); 
//		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//		srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
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
						checkPsnl0250Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
				}
	    	}
	    });    
	    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	    		sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
  	          	
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		
  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
  	    			}
  	    		});       
	    	} 
	    });
	    lcSch1_1.add(srhPayrMangDeptCd, new FormData("100%"));
		
//		srhPsnlMangDeptCd = new ComboBox<BaseModel>();
//		srhPsnlMangDeptCd.setName("srhPsnlMangDeptCd");
//		srhPsnlMangDeptCd.setDisplayField("psnlMangDeptNm");
//		srhPsnlMangDeptCd.setValueField("payrMangDeptCd");
//		srhPsnlMangDeptCd.setEmptyText("--단위기관선택--");
//		srhPsnlMangDeptCd.setFieldLabel("단위기관"); 
//		srhPsnlMangDeptCd.setStore(lsPsnlMangDeptCd);
		
//		lsPsnlMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//                GWTAuthorization.formAuthConfig(plFrmPsnl0250, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//                srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//                
//            }
//        });    
//		srhPsnlMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//  	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
//  	          sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPsnlMangDeptCd,"payrMangDeptCd"));
//  	          //--------------------부서 불러 오는 함수 ------------------------------------------------
//  	          lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//  	          //--------------------부서 불러 오는 함수 ------------------------------------------------
//  	          lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//  	             public void handleEvent(StoreEvent<BaseModel> be) {  
//  	               mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
//  	               srhDeptCd.getStore().add(mDtalistDeptCd);
//  	                 
//  	             }
//  	          });       
//  	    	} 
//  	    });
//		TextField<String> temp = new TextField<String>();
//		lcSchLeft.add(temp, new FormData("100%"));
		
		
		

//		LayoutContainer lcSchRight = new LayoutContainer();
//		lcSchRight.setStyleAttribute("paddingRight", "10px");
//		FormLayout frmlytSchRight = new FormLayout();
//		frmlytSchRight.setLabelWidth(100);
//		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
//		LayoutContainer lcSchRight2 = new LayoutContainer();
//		lcSchRight2.setLayout(new ColumnLayout());
		
		LayoutContainer lcSch1_2 = new LayoutContainer();
		FormLayout frmlytSch1_2 = new FormLayout();
		frmlytSch1_2.setLabelWidth(60);
		frmlytSch1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_2.setLayout(frmlytSch1_2);

//		searchHdofcCodtnCd = new ComboBox<BaseModel>();
//		searchHdofcCodtnCd.setFieldLabel("재직상태");
//		searchHdofcCodtnCd.setForceSelection(true);
//		searchHdofcCodtnCd.setMinChars(1);
//		searchHdofcCodtnCd.setDisplayField("commCdNm");
//		searchHdofcCodtnCd.setValueField("commCd");
//		searchHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
//		searchHdofcCodtnCd.setName("searchHdofcCodtnCd");
//		//searchHdofcCodtnCd.setEmptyText("--재직구분선택--");
//		searchHdofcCodtnCd.setSelectOnFocus(true);
//		searchHdofcCodtnCd.setStore(listStoreA003); 
//		lcSchRight_1.add(searchHdofcCodtnCd, new FormData("95%"));
		
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
//                srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//                srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
            	srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
              srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
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
        lcSch1_2.add(srhHdofcCodtnCd, new FormData("100%"));
		
		
		
		
//		searchEmymtDivCd = new ComboBox<BaseModel>();
//		searchEmymtDivCd.setFieldLabel("고용구분");
//		searchEmymtDivCd.setForceSelection(true);
//		searchEmymtDivCd.setMinChars(1);
//		searchEmymtDivCd.setDisplayField("commCdNm");
//		searchEmymtDivCd.setValueField("commCd");
//		searchEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//		searchEmymtDivCd.setEmptyText("--고용구분선택--");
//		searchEmymtDivCd.setSelectOnFocus(true);
//		searchEmymtDivCd.setStore(listStoreA002);
//		searchEmymtDivCd.setName("searchEmymtDivCd");
//		listStoreA002.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) { 
// 
//		        /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//                  String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
//                  GWTAuthorization.formAuthPopConfig(plFrmPsnl0250, "","searchEmymtDivCd", strArrDeptCd, "searchTypOccuCd", "searchYearBusinCd");
//                  GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
//                  // GWTAuthorization.formAuthConfig(plFrmPsnl0250, "","searchEmymtDivCd","searchDeptCd","searchTypOccuCd","searchYearBusinCd");
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//                  srhDeptCd.fireEvent(Events.Add);
//		    }
//		});   
//		lcSchRight_2.add(searchEmymtDivCd, new FormData("95%"));
        
        LayoutContainer lcSch1_3 = new LayoutContainer(new ColumnLayout());
        
        LayoutContainer lcSch1_3_1 = new LayoutContainer();
        
		FormLayout frmlytSch1_3 = new FormLayout();
		frmlytSch1_3.setLabelWidth(60);
		frmlytSch1_3.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_3_1.setLayout(frmlytSch1_3);
		
		srhEmymtDivCd =  new ComboBox<BaseModel>(); 
        srhEmymtDivCd.setName("srhEmymtDivCd");
        srhEmymtDivCd.setForceSelection(true);
        srhEmymtDivCd.setMinChars(1);
        srhEmymtDivCd.setDisplayField("commCdNm");
        srhEmymtDivCd.setValueField("commCd");
        srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
        srhEmymtDivCd.setEmptyText("--고용구분선택--");
        srhEmymtDivCd.setSelectOnFocus(true); 
        srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());//TODO
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
		                	checkPsnl0250Auth("srhEmymtDivCd", lsEmymtDivCd); 
              	 }
        	}
        }); 
        
        srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
        	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        		
        		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
        		BaseModel bmPayCd =  se.getSelectedItem(); 
        		if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//        			if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//        				if (srhDeptCd.getListView().getChecked().size() > 0) {  
//        					sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//        					List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//        					sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//        				}      
//                  
//                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//        				lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//                       
//        				srhBusinCd.setStore(lsBusinCd); 
//        				srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//        					public void handleEvent(StoreEvent<BaseModel> be) {  
//        					}
//        				});    
//        			} else {
//        			}  
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
        lcSch1_3_1.add(srhEmymtDivCd, new FormData("100%"));
		lcSch1_3.add(lcSch1_3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
	    LayoutContainer lcSch1_3_2 = new LayoutContainer();
	  //  lcSchCol.add(layoutContainer_101);
	    FormLayout frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setDefaultWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    lcSch1_3_2.setLayout(frmlytSch);
	    
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
//	    srhRepbtyBusinDivCd.setLabelSeparator("");
       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
	    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

              
            }
        });  
	    
	    lcSch1_3_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    lcSch1_3.add(lcSch1_3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
		
		LayoutContainer lcSch1_4 = new LayoutContainer();
		lcSch1_4.setLayout(new ColumnLayout());
		
		LayoutContainer lcSch1_4_1 = new LayoutContainer();
		FormLayout frmlytSch1_4_1 = new FormLayout();
		frmlytSch1_4_1.setLabelWidth(60);
		frmlytSch1_4_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch1_4_1.setLayout(frmlytSch1_4_1);
	 
		searchName = new TextField<String>();
		searchName.setName("searchName");
		searchName.setFieldLabel("성명");
		searchName.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				  
				searchName.validate();
				if (MSFSharedUtils.allowNulls(searchName.getValue()).trim().equals("")) {
					 srhSystemkey.setValue("");
                     searchResnRegnNum.setValue("");
				}
				if (boolKeyCode  && event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					searchResnRegnNum.setValue("");
					//boolKeyCode = false;
					fnPopupPsnl0100();  
					 
				//} else {
				//	boolKeyCode = true;
				} 
				
				super.componentKeyDown(event);
						
			}
		});
		 
//		searchName.addKeyListener(new KeyListener() {
//			public void componentKeyUp(ComponentEvent event) {
//				super.componentKeyUp(event);
//                searchName.validate();
//                
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                	srhSystemkey.setValue("");
//                	searchResnRegnNum.setValue(""); 
//                    fnPopupPsnl0100() ;
//                }
//			}
//		});
//		searchName.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) {  
//				if (MSFSharedUtils.allowNulls(searchName.getValue()).trim().equals("")) {
//					srhSystemkey.setValue("");
//                    searchResnRegnNum.setValue("");
//				}
//			} 
//		}); 
		lcSch1_4_1.add(searchName, new FormData("100%"));
		lcSch1_4.add(lcSch1_4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
		
		
		LayoutContainer lcSch1_4_2 = new LayoutContainer();
        Button btnHanNm = new Button("검색");
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
        	public void handleEvent(ButtonEvent e) {
                srhSystemkey.setValue("");
                searchResnRegnNum.setValue("");
                fnPopupPsnl0100() ;
            }
        });
        lcSch1_4_2.add(btnHanNm);
        lcSch1_4.add(lcSch1_4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
        
        LayoutContainer lcSch1_4_3 = new LayoutContainer();
		FormLayout frmlytSch1_4_3 = new FormLayout();
		frmlytSch1_4_3.setHideLabels(true);
		frmlytSch1_4_3.setLabelAlign(LabelAlign.LEFT);
		lcSch1_4_3.setLayout(frmlytSch1_4_3);
		searchResnRegnNum = new TextField<String>();
		searchResnRegnNum.setName("searchResnRegnNum");
		searchResnRegnNum.setLabelSeparator("");
		new TextFieldMask<String>(searchResnRegnNum, "999999-9999999");
		lcSch1_4_3.add(searchResnRegnNum, new FormData("100%"));
		lcSch1_4.add(lcSch1_4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		
        
        lcSch1.add(lcSch1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//단위기관
        lcSch1.add(lcSch1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	//재직
        lcSch1.add(lcSch1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.24));	//고용구분
        lcSch1.add(lcSch1_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));	//성명, 주민번호
		
		
        
        LayoutContainer lcSch2 = new LayoutContainer();
		lcSch2.setLayout(new ColumnLayout());
		
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
  	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
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
	      	    				mDtalistDeptCd = PersonalUtil.getDeptCdModelData(lsDeptCd) ; 
	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	      	    			} 
	      	    			
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
         
		 
		LayoutContainer lcSch2_2 = new LayoutContainer();
		FormLayout frmlytSch2_2 = new FormLayout();
		frmlytSch2_2.setLabelWidth(60);
		frmlytSch2_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_2.setLayout(frmlytSch2_2);
		
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
            			checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
            	}
            }
        });    
        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
        	@Override
        	public void handleEvent(ComponentEvent ce) { 
        		if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        			if (srhDeptCd.getListView().getChecked().size() > 0) {  
        				
        				sysComBass0500Dto.setBusinApptnYr(PayGenConst.ACC_CURR_YEAR);    
        				List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
        				
        				sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
        			}      
        			
        			//--------------------사업 불러 오는 함수 -------------------------------------------------
        			lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
        			//--------------------사업 불러 오는 함수 -------------------------------------------------
        			
        			srhBusinCd.setStore(lsBusinCd); 
        			srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
        				public void handleEvent(StoreEvent<BaseModel> be) {  
        				}
        			});    
        		} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	            		 
        			//2015.11.30 권한 직종가져오기  추가 
        			sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
         		   
        			String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
         		   	sysComBass0320Dto.setDeptCd(strDeptCd);
         		   
         		   	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
         		   	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
         		   		public void handleEvent(StoreEvent<BaseModel> be) {  
         		   			mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
         		   			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
         		   		}
         		   	});  
        		} else {
		        	
        			sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		      	   	
        			String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		      	   	sysComBass0320Dto.setDeptCd(strDeptCd);
		      	   	
		      	   	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		      	   	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		      	   		public void handleEvent(StoreEvent<BaseModel> be) {  
		      	   			mDtalistTypOccuCd = PersonalUtil.getTypOccuCdModelData(lsTypOccuCd) ;  
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
        lcSch2_2.add(srhDeptCd, new FormData("100%"));
        
        
        
//        srhDeptCd = new TextField<String>();
//        srhDeptCd.setName("srhDeptCd");
//        srhDeptCd.setVisible(false);
//        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//            @Override
//            public void handleEvent(BaseEvent be) { 
//              if(srhDeptCd.getValue() != null){
//               
//                  if (Constants.EMYMT_DIVCD02.equals(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") ))) {
//                      PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//                      dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));  
//                      dto.setDeptCd(srhDeptCd.getValue()); 
//                  
//                    //--------------------사업 불러 오는 함수 -------------------------------------------------
//                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//                      searchYearBusinCd.setStore(lsBusinCd); 
//                      searchYearBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//                          public void handleEvent(StoreEvent<BaseModel> be) {  
//                             // searchYearBusinCd.setValue(lsBusinCd.getAt(0));  
//                          }
//                      });    
//                  }
//              } 
//            }
//         });
//        plFrmPsnl0250.add(srhDeptCd);
//        srhMangeDeptCd = new TextField<String>();
//        srhMangeDeptCd.setName("srhMangeDeptCd");
//        srhMangeDeptCd.setVisible(false);
//        plFrmPsnl0250.add(srhMangeDeptCd);
//        srhMangeDeptNm = new TextField<String>();
//        srhMangeDeptNm.setName("srhMangeDeptNm");
//        srhMangeDeptNm.setVisible(false);
//        plFrmPsnl0250.add(srhMangeDeptNm);
//  
//        LayoutContainer lcDeptNm = new LayoutContainer(); 
//        frmlytSch = new FormLayout();
//        frmlytSch.setLabelWidth(60);
//        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//        lcDeptNm.setLayout(frmlytSch);
//      
//        srhDeptNm = new TextField<String>();
//        srhDeptNm.setName("srhDeptNm");
//        srhDeptNm.setFieldLabel("부서");  
//        srhDeptNm.addKeyListener(new KeyListener() {
//              public void componentKeyUp(ComponentEvent event) {
//                  super.componentKeyUp(event); 
//                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                      if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                          srhDeptCd.setValue("");
//                          srhMangeDeptCd.setValue("");
//                      }
//                      fnPopupCommP140(srhDeptNm.getValue());
//                  }
//              }
//          });
//         
//         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                    @Override
//                    public void handleEvent(BaseEvent be) { 
//                        if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//                            srhDeptCd.setValue("");
//                            srhMangeDeptCd.setValue("");
//                        }
//                    } 
//           });        
//          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//          
//          btnSrhDeptCd = new Button();
//          btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//          btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//        	  public void handleEvent(ButtonEvent e) { 
//        		  if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//        			  srhDeptCd.setValue("");
//                      srhMangeDeptCd.setValue("");
//        		  	}
//        		  fnPopupCommP140(srhDeptNm.getValue()); 
//        	  	}
//           });
//            
//        lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9));
//        lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
             
//		lcSchLeft.add(lccmlcDeptNm, new FormData("100%"));
		
		
		LayoutContainer lcSch2_3 = new LayoutContainer();
		FormLayout frmlytSch2_3 = new FormLayout();
		frmlytSch2_3.setLabelWidth(60);
		frmlytSch2_3.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_3.setLayout(frmlytSch2_3);
		 
//		srhBusinCd = new ComboBox<BaseModel>();
//	    srhBusinCd.setName("srhBusinCd");
//	    srhBusinCd.setForceSelection(true);
//	    srhBusinCd.setMinChars(1);
//	    srhBusinCd.setDisplayField("businNm");
//	    srhBusinCd.setValueField("businCd");
//	    srhBusinCd.setTriggerAction(TriggerAction.ALL);
//	    srhBusinCd.setEmptyText("--사업선택--");
//	    srhBusinCd.setSelectOnFocus(true); 
//	    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//	    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//	    srhBusinCd.setStore(lsBusinCd);
//	    srhBusinCd.setFieldLabel("사업");
//	    lcSch2_3.add(srhBusinCd, new FormData("100%"));
		
	    
	    lcSch2.add(lcSch2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));	//관리부서
        lcSch2.add(lcSch2_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));	//부서
        lcSch2.add(lcSch2_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.52));	//null
		
        
        /******************************** 검색조건추가로 인해 로우 하나 추가 됨 *************************/
        
        LayoutContainer lcSch3 = new LayoutContainer();
		lcSch3.setLayout(new ColumnLayout());
		
		//직종  
		LayoutContainer lcSch3_1 = new LayoutContainer();
		lcSch3_1.setLayout(new ColumnLayout());
		
		LayoutContainer lcSch3_1_1 = new LayoutContainer();
		FormLayout frmlytSch3_1_1 = new FormLayout();
		frmlytSch3_1_1.setLabelWidth(60);
		frmlytSch3_1_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch3_1_1.setLayout(frmlytSch3_1_1);
		
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
        
        lcSch3_1_1.add(srhDeptGpCd, new FormData("100%"));
        lcSch3_1.add(lcSch3_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		
		
		
		LayoutContainer lcSch3_1_2 = new LayoutContainer();
		FormLayout frmlytSch3_1_2 = new FormLayout();
		frmlytSch3_1_2.setLabelWidth(0);
		frmlytSch3_1_2.setDefaultWidth(0);
//		frmlytSch3_1_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch3_1_2.setLayout(frmlytSch3_1_2);
		
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
        srhTypOccuCd.setName("srhTypOccuCd"); 
        srhTypOccuCd.setEmptyText("--직종선택--"); 
        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
        srhTypOccuCd.setHideLabel(true);
//        srhTypOccuCd.setLabelSeparator("");
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
//     	                    if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//     	                       for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//     	                           ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//     	                           if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//     	                               mdSelect = tpMdSelect;
//     	                           } 
//     	                       }  
             			srhTypOccuCd.getListView().setChecked(mdSelect, true); 
             			srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
//     	                    }  
                     }  
            		 }
//                  srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
            		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            		  * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		          	  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		          	  * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//            		 	checkPsnl0250Auth("srhTypOccuCd", lsTypOccuCd); 
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
            	displayDtilOccuInttnCd();
            } 
        }); 
//		searchTypOccuCd = new ComboBox<BaseModel>();
//		searchTypOccuCd.setFieldLabel("직 종");
//		searchTypOccuCd.setForceSelection(true);
//		searchTypOccuCd.setMinChars(1);
//		searchTypOccuCd.setDisplayField("commCdNm");
//		searchTypOccuCd.setValueField("commCd");
//		searchTypOccuCd.setTriggerAction(TriggerAction.ALL);
//		searchTypOccuCd.setEmptyText("--직종선택--");
//		searchTypOccuCd.setSelectOnFocus(true);
//		// stTypeOccuCd = new ListStore<BaseModel>();
//		searchTypOccuCd.setStore(listStoreA041);
//		searchTypOccuCd.setName("searchTypOccuCd");
//		listStoreA041.addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) { 
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//                  String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
//                  GWTAuthorization.formAuthPopConfig(plFrmPsnl0250, "","searchEmymtDivCd",strArrDeptCd,"searchTypOccuCd","searchYearBusinCd");
//                  GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
//                  // GWTAuthorization.formAuthConfig(plFrmPsnl0250, "","searchEmymtDivCd","searchDeptCd","searchTypOccuCd","searchYearBusinCd");
//                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//            }
//        });   
//		lcSchRight3_1.add(searchTypOccuCd, new FormData("95%"));
        lcSch3_1_2.add(srhTypOccuCd, new FormData("100%"));
        lcSch3_1.add(lcSch3_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		
		
		LayoutContainer lcSch3_1_3 = new LayoutContainer(); 
		FormLayout frmlytSch3_1_3 = new FormLayout();
		frmlytSch3_1_3.setHideLabels(true);
		frmlytSch3_1_3.setLabelAlign(LabelAlign.LEFT);
		lcSch3_1_3.setLayout(frmlytSch3_1_3);
		
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setHideLabel(true);
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
        srhDtilOccuInttnCd.setLabelSeparator("");
        srhDtilOccuInttnCd.setFieldLabel("");
        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
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
        lcSch3_1_3.add(srhDtilOccuInttnCd, new FormData("100%"));
        lcSch3_1.add(lcSch3_1_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		
		
		LayoutContainer lcSch3_2 = new LayoutContainer();
		FormLayout frmlytSch3_2 = new FormLayout();
		frmlytSch3_2.setLabelWidth(60);
		frmlytSch3_2.setLabelAlign(LabelAlign.RIGHT);
		lcSch3_2.setLayout(frmlytSch3_2);
		
//		searchYearBusinCd = new ComboBox<BaseModel>();
//		searchYearBusinCd.setFieldLabel("사업");
//		searchYearBusinCd.setForceSelection(true);
//		searchYearBusinCd.setMinChars(1);
//		searchYearBusinCd.setDisplayField("businNm");
//	    searchYearBusinCd.setValueField("businCd");
//		searchYearBusinCd.setTriggerAction(TriggerAction.ALL);
//		searchYearBusinCd.setEmptyText("--사업선택--");
//		searchYearBusinCd.setSelectOnFocus(true);
//		searchYearBusinCd.setStore(new ListStore<BaseModel>());
//		searchYearBusinCd.setName("searchYearBusinCd");
//		lcSchRight3_3.add(searchYearBusinCd, new FormData("100%"));
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
	    lcSch3_2.add(srhBusinCd, new FormData("100%"));
			    
		LayoutContainer lcSch3_3 = new LayoutContainer();
		FormLayout frmlytSch3_3 = new FormLayout();
		frmlytSch3_3.setLabelWidth(60);
		frmlytSch3_3.setLabelAlign(LabelAlign.RIGHT);
		lcSch3_3.setLayout(frmlytSch3_3);
    
       // lcSch3_3.add(srhDeptCd, new FormData("100%"));
        
	    lcSch3.add(lcSch3_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.48));	//직종
        lcSch3.add(lcSch3_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.51));	//사업
        lcSch3.add(lcSch3_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.01));	//사업

		lcSchCol.add(lcSch1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcSchCol.add(lcSch2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcSchCol.add(lcSch3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmPsnl0250.add(fieldSet);
		// vp.add(panel);
	}
	

	private void  displayDtilOccuInttnCd() {
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
            
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
			sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
			
			List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
			String strDeptCd = PersonalUtil.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = PersonalUtil.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                
            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
            	
            	//직종세 초기화
            	srhDtilOccuInttnCd.getInitStore(); 
            	srhDtilOccuInttnCd.setValue("");
            	
            	lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
            	//  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                    
            	lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
            		public void handleEvent(StoreEvent<BaseModel> be) {  
            			mDtalistDtilOccuInttnCd = PersonalUtil.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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
//        String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//        if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//            sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//            sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//                lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//                srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
//            }
//        }   
	}
	//출력대상자정보 그리드
	private void createListGrdForm() {
			
		FieldSet fieldSetGrd = new FieldSet();  
		fieldSetGrd.setHeadingHtml("출력대상자정보");
		    
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();  
		lcStdGrid.setLayout(frmlytStd);  
		    
		ContentPanel cpGrid = new ContentPanel();   
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);   
		cpGrid.setLayout(new FitLayout());  
		cpGrid.setSize(945, 440);
		    
		psnl0100GridPanel = new MSFGridPanel(psnl0100Def, false, false, false, false, false);
		psnl0100GridPanel.setHeaderVisible(false);  
		psnl0100GridPanel.setBodyBorder(true);
		psnl0100GridPanel.setBorders(true);
		final Grid psnl0126Grid = psnl0100GridPanel.getMsfGrid().getGrid();
		psnl0126Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (psnl0100GridPanel.getCurrentlySelectedItem() != null) {    
					setRecord(psnl0100GridPanel.getCurrentlySelectedItem());
	   			} 
	   		}
		}); 
		cpGrid.add(psnl0100GridPanel); 
	
		lcStdGrid.add(cpGrid);   
		fieldSetGrd.add(lcStdGrid);   
			      
		plFrmPsnl0250.add(fieldSetGrd, new FormData("100%"));

	}
	
	public void reload() {
		// TODO Auto-generated method stub
//		if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))){
//			if (Constants.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
//				return;
//			} 
//		} 
				    
		IColumnFilter filters = null;
		psnl0100GridPanel.getTableDef().setTableColumnFilters(filters);
		
		
		psnl0100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0100GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0100GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
		if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
			String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
  	  		String chkkey = "";
  	           
  	  		for (int i=0; i<ray.length; i++){ 
  	  			BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
  	  			chkkey += bmData.get("commCd")+","; 
  	  		}
  	  		strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
		}
		psnl0100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
//		String strHdofcCodtnCd = PersonalUtil.getStrValToBMMultiCombo(lsHdofcCodtnCd, srhHdofcCodtnCd.getValue(),"commCdNm","hdofcCodtnCd");  
//		psnl0100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		
		
		
		
		psnl0100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
		String strDeptCd = PersonalUtil.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		psnl0100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
		           
		String strTypOccuCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		psnl0100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		
		//String strPyspGrdeCd = PersonalUtil.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
		//psnl0100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
		
		String strDtilOccuInttnCd = PersonalUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		psnl0100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		       
		psnl0100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		psnl0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		psnl0100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(searchName.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		psnl0100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(searchResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
		psnl0100GridPanel.reload();
		
	}
		
	public void setRecord(BaseModel record) {
		this.record = record;
	}		
	

	private void createCheckBoxGrid() {
		
//		FieldSet fieldSet = new FieldSet();
//		fieldSet.setHeadingHtml("출력대상자정보");
//		fieldSet.setSize("965px", "470px");
//
//		RowNumberer r = new RowNumberer();
//
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		configs.add(r);
//
//		sm = new CheckBoxSelectionModel<Psnl0100DTO>();
//		sm.setSelectionMode(SelectionMode.MULTI);
//		
//		configs.add(sm.getColumn());
//
//		ColumnConfig column = new ColumnConfig();
//		column.setId("hanNm");
//		column.setHeaderText("성명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("hanNm");
//			}
//		});
//		configs.add(column);
//		
//
//		column = new ColumnConfig();
//		column.setId("resnRegnNum");
//		column.setHeaderText("주민번호");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("resnRegnNum");
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("emymtDivCdNm");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(120);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				// TODO Auto-generated method stub
//				return model.get("emymtDivCdNm");
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig();
//		column.setId("currAffnDeptCdNm");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(250);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				return model.get("currAffnDeptCdNm");
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig("typOccuCdNm", "직종", 250);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0100DTO>() {
//			@Override
//			public Object render(Psnl0100DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0100DTO> store, Grid<Psnl0100DTO> grid) {
//				return model.get("typOccuCdNm");
//			}
//		});
//		configs.add(column);
//
//
//		ColumnModel cm = new ColumnModel(configs);
//
//		ContentPanel cp = new ContentPanel();
//		cp.setHeaderVisible(false);
//		cp.setFrame(true);
//		cp.setIcon(MSFMainApp.ICONS.table());
//		cp.setLayout(new FitLayout());
//		cp.setSize(600, 300);
//
//		psnl0100Grid = new Grid<Psnl0100DTO>(psnl0100Store, cm);
//		psnl0100Grid.setStateId("psnl0100GridId");
//		psnl0100Grid.setStateful(true);
//		psnl0100Grid.setLoadMask(true);
//		psnl0100Grid.setAutoExpandColumn("typOccuCdNm");;
//		psnl0100Grid.setBorders(true);
//		psnl0100Grid.setSelectionModel(sm);
////		psnl0100Grid.setColumnReordering(true);
//		//psnl0100Grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
//		psnl0100Grid.addPlugin(sm);
//
//
//		LayoutContainer lcStdGrid = new LayoutContainer();
//		lcStdGrid.setStyleAttribute("paddingRight", "5px");
//		lcStdGrid.setStyleAttribute("paddingLeft", "5px");

		
		
		FieldSet fieldSet_1 = new FieldSet();
		fieldSet_1.setHeadingHtml("출력조건");
		fieldSet_1.setCollapsible(false);

		LayoutContainer layoutContainer = new LayoutContainer();

		outputTypeRadiogroup = new RadioGroup();
		outputTypeRadiogroup.setBorders(false);
		outputTypeRadiogroup.setFieldLabel("출력조건");

		Radio radio = new Radio();
		radio.setBoxLabel("근로계약서");
		radio.setHideLabel(true);
		radio.setValue(true);
		radio.setValueAttribute("PSNLT0250"); 
		outputTypeRadiogroup.add(radio);

		radio = new Radio();
		radio.setBoxLabel("보안서약서");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0251"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("신상카드");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0253"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("인사기록요약서");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0254"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("네임카드");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0255"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("사진명부");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0256"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("휴직자명부");
		radio.setHideLabel(true);
		radio.setValueAttribute("PSNLT0257"); 
		outputTypeRadiogroup.add(radio);
		
		radio = new Radio();
		radio.setBoxLabel("출근부");
		radio.setHideLabel(true);
		//TODO 출근부 나중에 만들어서 다시
		radio.setValueAttribute("temp"); 
		outputTypeRadiogroup.add(radio);
		
		layoutContainer.add(outputTypeRadiogroup);
		
		
		fieldSet_1.add(layoutContainer);

		layoutContainer.setLayout(new FlowLayout(5));
		layoutContainer.setBorders(true);
		plFrmPsnl0250.add(fieldSet_1);
		
//		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		lcStdGrid.setLayout(frmlytStd); TODO 

//		ContentPanel cpGrid = new ContentPanel();
//		cpGrid.setBodyBorder(false);
//		cpGrid.setHeaderVisible(false);
//		cpGrid.setLayout(new FitLayout());
//		cpGrid.setSize(940, 440);

//		cpGrid.add(psnl0100Grid);
//		psnl0100Grid.setHeight("345px");
//		lcStdGrid.add(cpGrid);
//		fieldSet.add(lcStdGrid);

//		plFrmPsnl0250.add(fieldSet);

	}
	
	//검색조건 초기화
	private void searchInit() {
//		srhPayrMangDeptCd.setValue(new BaseModel());	//단위기관
		srhHdofcCodtnCd.setValue("");					//재직상태
//		srhEmymtDivCd.setValue(new BaseModel());		//고용구분
	    searchName.setValue("");						//성명
		searchResnRegnNum.setValue("");					//주민등록번호
		srhSystemkey.setValue("");						//시스템키
//		srhDeptCd.setValue("");							//부서
//		srhTypOccuCd.setValue("");						//직종
//		srhDtilOccuInttnCd.setValue("");				//직종세
//		srhBusinCd.setValue(new BaseModel());			//사업
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/		
	//성명
	private void fnPopupPsnl0100()  {
		
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(searchName.getValue());  //인사 
        
		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
        
		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource();
                if (!"".equals(mapModel.get("systemkey"))) { 
                	srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));		//시스템키
                	searchName.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));				//성명
                	searchResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));	//주민번호 
                }  
            }
        });
    }
	
	 //부서 
//    private void fnPopupCommP140(String deptCd) {
//        MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//        
//        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//       
//        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {
//                BaseModel mapModel = (BaseModel)be.getSource();
//                if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                    srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                    srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                    srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                    srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));  
//                }  
//            }
//        });
//    }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	

//	public native String getDetailTemplate() /*-{
//		return [ '<div class="details">', '<tpl for=".">',
//				'<img src="{modPath}"><div class="details-info">',
//				'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
//				'<span>{sizeString}</span>', '<b>Last Modified:</b>',
//				'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
//				.join("");
//	}-*/;
	


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

