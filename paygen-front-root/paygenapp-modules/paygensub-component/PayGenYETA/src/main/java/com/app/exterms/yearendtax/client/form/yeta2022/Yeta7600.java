package com.app.exterms.yearendtax.client.form.yeta2022;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.LookupYeta7600YetaYr;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161010DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta4000Def;
import com.app.exterms.yearendtax.client.languages.YetaConstants;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0100Service;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0100ServiceAsync;
import com.app.exterms.yearendtax.client.service.yeta2022.Yeta7600Service;
import com.app.exterms.yearendtax.client.service.yeta2022.Yeta7600ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
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
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
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
public class Yeta7600   extends MSFPanel {

	
	
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    private YetaConstants lblYetaConst = YetaConstants.INSTANCE; 
    
    private VerticalPanel vp;
    private FormPanel plFrmYeta7600; 
    private String txtForm = "";
    private XTemplate detailTp;
 
    private Yeta4000Def yeta4000def = new Yeta4000Def("Yeta7600");
    private MSFGridPanel msfGridPanel;
  
	// -------------- 권한 설정 객체 시작 --------------
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	// -------------- 권한 설정 객체 종료 --------------
	
	 //귀속년도 
    private LookupYeta7600YetaYr lkApptnYr = new LookupYeta7600YetaYr();
    private MSFGridPanel payYrGridPanel;
     
	//직종콤보
//		private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		private MSFGridPanel typOccuCdGridPanel;

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
//    private ButtonBar topYeta7600Bar;
  //  private Button btnYeta7600New;
  //  private Button btnYeta7600Save;
  //  private Button btnYeta7600Del;
//    private Button btnYeta7600Sreach;
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 검색변수 선언 
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
   
	private ComboBox<BaseModel> srhPayYr; 					/** column  귀속년도 : payYr */
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; 		// 호봉제구분코드
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
	// private ComboBox<BaseModel> srhDeptCd ; //부서
	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private ComboBox<BaseModel> srhDeptGpCd; 				// 부서직종그룹코드
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
	// private ComboBox<BaseModel> srhTypOccuCd; //직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세

	private TextField<String> srhHanNm;			 			// 성명
	private TextField<String> srhResnRegnNum; 				// 주민번호
	private HiddenField<String> srhSystemkey; 				// 시스템키

	private List<ModelData> mDtalistHdofcCodtnCd;
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
   
	private HiddenField<String> dpobCd; // 사업장코드
    
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
 			  private void checkYeta7600Auth( String authAction, ListStore<BaseModel> bm) {   
 		    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
 				 
 				//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
 			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
 				   

 				if (!maskTracker) { unmask(); }  
 			 authExecEnabled() ;
           
		                //MSFMainApp.unmaskMainPage();
 			 gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
 				   }
 			  }
 			  

 			 private void authExecEnabled() { 
 			   //------------------
 			   //----------------------------------------------------
	                  Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhBusinCd};
	               
	                  gwtAuthorization.formAuthFieldConfig(fldArrField);
	               
	              
	        	  Date today = new Date(); 
	        	    // A custom date format
	        	  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
	        	 
	        	 srhPayYr.setValue(lsPayYrStore.findModel("payYr", fmt.format(today)) );
	        	 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                    * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					//gwtAuthorization.formAuthConfig(plFrmYeta7600, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd");
	                  // GWTAuthorization.formAuthConfig(plFrmPayr4400, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
	                   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                    * 권한설정을 위한 콤보처리를 위한 메서드 종료
	                    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	                   //  srhDeptCd.fireEvent(Events.Add); 
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

		authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
		authMapDef.put("srhEmymtDivCd", Boolean.FALSE);
		authMapDef.put("srhDeptCd", Boolean.FALSE);
		// authMapDef.put("srhTypOccuCd",Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			// 권한 검색조건처리를 위해 추가된 부분
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
    
	// 화면 폼 바인딩 처리
	private void setYeta7600FormBinding() {

		// formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt,
		// "srhPubcHodyCtnt"));
		// formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum,
		// "degtrResnRegnNum"));

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
	//private Yeta7600ServiceAsync Yeta7600Service = Yeta7600Service.Util.getInstance();
	    
	    
	// -------------- store 선언 시작 --------------   
  private ListStore<BaseModel> lsPayYrStore 		= new ListStore<BaseModel>();	//년도 
	private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();   //단위기관
	private ListStore<BaseModel> lsEmymtDivCd		= new ListStore<BaseModel>();  	//고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd	= new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();  	//직종
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>();  	//부서
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();  	//사업
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	
	// -------------- store 선언 종료 --------------
	
	// -------------- DTO 선언 시작 --------------
	private PrgmComBass0150DTO sysComBass0150Dto;
	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0350DTO sysComBass0350Dto;	//직종세
	private PrgmComBass0400DTO sysComBass0400Dto; 	//부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; 	//사업코드  
	 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
	// -------------- DTO 선언 종료 --------------
	
	private BaseModel record;
  
	 
/**
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
* 	Rpc Service 선언부 종료
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
**/
  

/**
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
* 	print Service 선언부 시작
*  rex 추가로 리포트 타입변경
*  fileName : 출력파일명 
*  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
**/
	
	private void Yeta7600Print(String fileName, String repType) {
		if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			RdaPrint(fileName);
		} else if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			RexPrint(fileName);
		} else {
			Window.alert("출력 타입 오류!");
		}
	}	
	
	//rda
	private void RdaPrint(String fileName) {
		 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
		
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		 
		//검색조건
	    String serarchParam = "";
	    
	 //권한 설정으로 인해 추가된 부분 
	    String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
	    String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
	 	String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
	 	String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
	     	     
	    serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";   //$1
	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") +"]";  //$2
	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";   //$3
	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"emymtDivCd")+"]";    //$4 
	    //20151212-추가 시작 
	    if (payrMangDeptCd.equals(deptCdAuth)) { 
	    	serarchParam += "[]"; //$5
      } else {
      	serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$5
      }  
	    //20151212-추가 끝
	    serarchParam += "["+ YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$6
	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";       //$7
	    
		//출력목록리스트 
		List<BaseModel> list = msfGridPanel.getGrid().getSelectionModel().getSelectedItems();
		String checkedSystemKeys = "";
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
		}
      serarchParam = serarchParam+"["+checkedSystemKeys+"]"; // $8
      
      //20151212-변경추가 시작 
	    serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //$9 //유우져 아이디 넘김 
		serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$10
      
      
      
//      //TODO 확인
//      if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//          serarchParam += "[]";  //$10
//          serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$11
//      
//      } else {
//          
          //직종 권한에 대한 처리 추가 기본 처리  $10로해서 처리 할것...$10
//          if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                    && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//              serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//          } else {
//              serarchParam += "[]";
//          }  
//          serarchParam += "[]";  //$11
//      }
      
    //도장 출력을 위해 추가 2014-11-06 
      String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
      if(MSFSharedUtils.paramNull(myImgUrl)) {
         // myImgUrl = "http://105.19.10.32:8080";
      	//경로오류 출력 
      	
      }
      serarchParam += "["+  myImgUrl  +"]"; //$11
      
      //권한처리를위해 넘기는 변수 2개추가 
      serarchParam += "["+deptCdAuth+"]"; //$12 부서 
      serarchParam += "["+dtilOccuInttnCdAuth+"]"; //$13 직종세 
      //20151212-추가 끝 
      
      GWT.log("popup : " + serarchParam);
		String strParam = "/rp " + serarchParam;
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	}	
	
	
	//rex
	private void RexPrint(String fileName) {
		 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
						
		// reb 출력물
		String rexFileName = fileName+".crf";
		// 보낼 파라미터
		 
		//검색조건
	    String serarchParam = ""; 
	    
	    //권한 설정으로 인해 추가된 부분 
	    String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
	    String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
	 	String deptCdAuth = MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
	 	String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
	 		
	    serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			//$1
	    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr") +"⊥";  					//$2
	    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";   	//$3
	    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";    			//$4 
	    //20151212-추가 시작 
	    if (payrMangDeptCd.equals(deptCdAuth)) { 
	    	serarchParam += "⊥"; //$5
      } else {
      	serarchParam += ""+ YetaUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; //$5
      }  
	    //20151212-추가 끝  	    
	    
	    
	    serarchParam += ""+YetaUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";	//$6
	    serarchParam += ""+MSFSharedUtils.allowNulls(YetaUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd"))+"⊥"; //$7
	    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";       			//$8
	    
		//출력목록리스트 
		List<BaseModel> list = msfGridPanel.getGrid().getSelectionModel().getSelectedItems();
		String checkedSystemKeys = "";
		if(list != null && list.size() > 0){
			String chkkey = "";
			for(BaseModel bm : list){
				chkkey += "'"+bm.get("systemkey")+"',";
			}
			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
		}
      serarchParam = serarchParam+""+checkedSystemKeys+"⊥"; //$9
      
      
      //20151212-변경추가 시작 
	    serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  //$10 //유우져 아이디 넘김 
		serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$11
		
  	//도장 출력을 위해 추가 2014-11-06 //$12
      String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
      if(MSFSharedUtils.paramNull(myImgUrl)) {
      	// myImgUrl = "http://105.19.10.32:8080";
      	MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "이미지 경로 오류 " + myImgUrl, null);
      	//경로오류 출력 
      }
          serarchParam += ""+  myImgUrl  +"⊥";		
		  
		//권한처리를위해 넘기는 변수 2개추가 
		serarchParam += ""+deptCdAuth+"⊥"; //$13 부서 
		serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; //$14 직종세 
		//20151212-추가 끝 	
  
		serarchParam += ""+mangeDeptCd+"⊥"; //$15 관리부서 
		
		GWT.log("popup : " + serarchParam);
		String strParam = "" + serarchParam;
		
		//GWT 타입으로 팝업 호출시  postCall true 설정
		PrintUtils.setPostCall(true);
		PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
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

	public ContentPanel getViewPanel() {
		if (panel == null) {
			// 콤보 권한초기화
			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createYeta7600Form(); 		// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
			createCheckBoxGrid();
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
	public Yeta7600() {

		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	public Yeta7600(String txtForm) {
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
	private void createYeta7600Form() {

		plFrmYeta7600 = new FormPanel();
		plFrmYeta7600.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  "+ lblYetaConst.title_Yeta7600YetaYr()));
		plFrmYeta7600.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta7600.setBodyStyleName("pad-text");
		plFrmYeta7600.setPadding(2);
		plFrmYeta7600.setFrame(true); 

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblYetaConst.title_Yeta7600YetaYr(),"Yeta7600");
				}
			});
		plFrmYeta7600.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta7600.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		   //멀티콤보박스 닫기 
		plFrmYeta7600.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
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
                  }  else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
                      //직종세
                      srhDtilOccuInttnCd.showClose(ce);
                      mutilCombo = false;
                  }  
             }
          } 
      });
      
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);

		Button btnYeta7600Sreach = new Button("조회");
		btnYeta7600Sreach.setIcon(MSFMainApp.ICONS.search16());
		buttonBar.add(btnYeta7600Sreach);
		btnYeta7600Sreach.addListener(Events.Select,new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				reload();
			}
		});
		  	
		Button btnYeta7600Print = new Button("인쇄");
		btnYeta7600Print.setIcon(MSFMainApp.ICONS.print16());
		buttonBar.add(btnYeta7600Print);
		btnYeta7600Print.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// Print버튼 클릭시 처리
				// Yeta7600Print("PAYRT4550");
				Yeta7600Print("PAYRT4550", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
		});
		
		Button btnYeta7600Exl = new Button("엑셀");
		btnYeta7600Exl.setIcon(MSFMainApp.ICONS.excel16());
		buttonBar.add(btnYeta7600Exl);
		btnYeta7600Exl.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//엑셀저장  
  			excelFileExport();
			}
		});
		
		
		
	  	plFrmYeta7600.add(buttonBar);    
	  	 
	
		vp.add(plFrmYeta7600);
		
		//엣지변환
		//plFrmYeta7600.setSize("990px", "680px");
		plFrmYeta7600.setSize("990px", "730px");
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
		  
		srhSystemkey = new HiddenField<String>(); 	// 시스템키
		dpobCd 		= new HiddenField<String>(); 	// 사업장코드

		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
			  
			 
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
			 
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
				
				
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		lsTypOccuCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd);
				srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
			}
		}); 
 		   

		 //-------------------관리부서 추가  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);

		lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});    
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------   
	 		 
		ContentPanel payYrGrid = new ContentPanel();
		payYrGrid.setVisible(false);

		// 년도 콤보처리
		payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true);
		payYrGridPanel.getGrid().addListener(Events.ViewReady,new Listener<ComponentEvent>() {
			public void handleEvent(ComponentEvent be) {
				payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged,new Listener<StoreEvent<BaseModel>>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels());
					}
				});
			}
		});

		payYrGrid.add(payYrGridPanel);
		plFrmYeta7600.add(payYrGrid);
		  
		plFrmYeta7600.setLayout(new FlowLayout());

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
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchLeft.setLayout(frmlytSch);
		    
		srhPayYr = new ComboBox<BaseModel>();
		srhPayYr.setName("srhPayYr");
		srhPayYr.setForceSelection(true);
		srhPayYr.setMinChars(1);
		srhPayYr.setDisplayField("payYrDisp");
		srhPayYr.setValueField("payYr");
		srhPayYr.setTriggerAction(TriggerAction.ALL);
		srhPayYr.setEmptyText("--년도선택--");
		srhPayYr.setSelectOnFocus(true);
		srhPayYr.setReadOnly(false);
		srhPayYr.setEnabled(true);
		srhPayYr.setStore(lsPayYrStore);
		srhPayYr.setFieldLabel("귀속년도");
		lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {

				EventType type = be.getType();
				if (type == Store.Add) {
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkYeta7600Auth("srhPayYr", lsPayYrStore);
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
		    lcSchLeft.add(srhPayYr, new FormData("100%")); 
		    
		    
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
			                	checkYeta7600Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	                	 }
              }
          });  
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				sysComBass0400Dto = new PrgmComBass0400DTO(); 
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
				// --------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData(sysComBass0400Dto);
				// --------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd.addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
						mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd);
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
		layoutContainer_6.add(srhHanNm, new FormData("100%"));
		srhHanNm.setFieldLabel("성명");
		srhHanNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				//
				srhHanNm.validate();
				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});
//          srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//              @Override
//              public void handleEvent(BaseEvent be) {  
//                  if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                      srhSystemkey.setValue("");
//                      srhResnRegnNum.setValue("");
//                  }
//               
//              } 
//        }); 
          
		layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_btn = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		layoutContainer_btn.setLayout(frmlytSch);

		Button btnHanNm = new Button("검색");
		// layoutContainer_5.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();

			}
		});
          
		layoutContainer_btn.add(btnHanNm);
		layoutContainer_5.add(layoutContainer_btn,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.14));

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setDefaultWidth(0);
		// frmlytSch.setLabelWidth(0);
		// frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);

		srhResnRegnNum = new TextField<String>();
		srhResnRegnNum.setHideLabel(true);
		srhResnRegnNum.setName("srhResnRegnNum");
		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
		// srhResnRegnNum.setFieldLabel("주민번호");
		srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim()
						.equals("")) {
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

		LayoutContainer layoutContainer_15 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSch);

		srhEmymtDivCd = new ComboBox<BaseModel>();
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
			                	checkYeta7600Auth("srhEmymtDivCd", lsEmymtDivCd); 
	                	 }    
                  
              }
          });    
		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				// 부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
				BaseModel bmPayCd = se.getSelectedItem();
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					srhDeptCd.getListView().fireEvent(Events.CheckChanged);
					srhBusinCd.setEnabled(true);
					srhTypOccuCd.reset();
					srhTypOccuCd.setEnabled(false);
							// srhDtilOccuInttnCd.reset();
							// srhDtilOccuInttnCd.setEnabled(false);
				} else if (bmPayCd != null&& MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
					// 20151130 추가 수정
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
		layoutContainer_15.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
          
          
		LayoutContainer layoutContainer_101 = new LayoutContainer();
		layoutContainer_101.setBorders(false);

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_101.setLayout(frmlytSch);

		srhRepbtyBusinDivCd = new ComboBox<BaseModel>();
		srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		srhRepbtyBusinDivCd.setForceSelection(true);
		srhRepbtyBusinDivCd.setAllowBlank(true);
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
		// srhRepbtyBusinDivCd.setFieldLabel("고용구분");
		lsRepbtyBusinDivCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {

			}
		});
		    
		layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_101,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 			// 귀속년도
		lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 	// 단위기관
		lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	// 고용구분
		lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 	// 성명

		fieldSet.add(lcSchCol, new FormData("100%"));

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setLayout(new ColumnLayout());

		
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
		  	    				mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
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
			      	    				mDtalistDeptCd = YetaUtils.getDeptCdModelData(lsDeptCd) ; 
			      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			      	    			} 
			      	    			
			      	    		}); 
			      	    		emptyCheck = false;
		                	}
		                 }  
		            } 
		        });   
		       
		        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
		        
		LayoutContainer layoutContainer12 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer12.setLayout(frmlytSch);
          
          
		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		// srhDeptCd.setForceSelection(true);
		// srhDeptCd.setMinChars(1);
		// srhDeptCd.setDisplayField("deptNmRtchnt");
		// srhDeptCd.setValueField("deptCd");
		// srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		// srhDeptCd.setSelectOnFocus(true);
		// srhDeptCd.setReadOnly(false);
		// srhDeptCd.setEnabled(true);
		// srhDeptCd.setStore(lsDeptCd );
		// srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.getStore().add(mDtalistDeptCd);
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {

				EventType type = be.getType();
				if (type == Store.Add) {
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
					 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					checkYeta7600Auth("srhDeptCd", lsDeptCd);
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
 	            		   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
 	            		   sysComBass0320Dto.setDeptCd(strDeptCd);
 	            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
 	            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
 	           	            public void handleEvent(StoreEvent<BaseModel> be) {  
 	           	             
 	                             mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
 	                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
 	                              
 	                           }
 	                       });  
              	    
		                  } else {
		                	  
		                	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			            		   String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			            		   sysComBass0320Dto.setDeptCd(strDeptCd);
		                	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		             		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		            	            public void handleEvent(StoreEvent<BaseModel> be) {  
		            	             
		                              mDtalistTypOccuCd = YetaUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		                              srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		                               
		                            }
		                        });   
		                  }
                        
                    }  
            
                  });  
           
		srhDeptCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}

			}	
		});

         
		layoutContainer12.add(srhDeptCd, new FormData("100%"));
		layoutContainer12.setBorders(false);



		layoutContainer_3.add(lcSch2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); // 부서
		layoutContainer_3.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); // 직종
		//layoutContainer_3.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); // 사업

		fieldSet.add(layoutContainer_3);
		layoutContainer_3.setBorders(false);
		
		LayoutContainer layoutContainer_3_1 = new LayoutContainer();
		layoutContainer_3_1.setLayout(new ColumnLayout());
		
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_211 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_211.setLayout(frmlytSch);

		srhDeptGpCd = new ComboBox<BaseModel>();
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

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		// frmlytSch.setLabelWidth(70);
		frmlytSch.setDefaultWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
		    
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		srhTypOccuCd.setHideLabel(true);
		// srhTypOccuCd.setFieldLabel("직종");
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {

				EventType type = be.getType();
				if (type == Store.Add) {
					// 2015.11.30 추가
					if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
						if (!gwtExtAuth.getEnableTypOccuCd()) {
							ModelData mdSelect = srhTypOccuCd.getStore().getAt(0);

							srhTypOccuCd.getListView().setChecked(mdSelect, true);
							srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));

							}
						}
						/**
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
						 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
						 * lsTypOccuCd 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로 없으면 ""
						 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
						 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 */
						// checkYeta7600Auth("srhTypOccuCd", lsTypOccuCd);
					}
				}
			});

		srhTypOccuCd.getListView().addListener(Events.CheckChanged, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				// 2015.11.30 추가
				displayDtilOccuInttnCd();

			}
		});

		srhTypOccuCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				}
			}
		});
		layoutContainer_2.add(srhTypOccuCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);
		    
		LayoutContainer lcSchRight = new LayoutContainer();
		// lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		// fieldSet.setLayout(layout);
		lcSchRight.setLayout(frmlytSch);
	  	      
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		srhDtilOccuInttnCd.setWidth(100);
		srhDtilOccuInttnCd.setHideLabel(true);
		srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					// GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					// GWT.log(" b" + ce.getEvent().getType());
				} else {
				}
			}
		});
		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));

		lcTypOccuCd.add(layoutContainer_211, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		lcTypOccuCd.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		lcTypOccuCd.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
		         
		    
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
		    

		//layoutContainer_3_1.add(layoutContainer12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); // 부서
		layoutContainer_3_1.add(lcTypOccuCd, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); // 직종
		layoutContainer_3_1.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); // 사업

		fieldSet.add(layoutContainer_3_1);
		layoutContainer_3_1.setBorders(false);

		plFrmYeta7600.add(fieldSet);
		// vp.add(panel);
	}
	  

    
	  private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
            
            //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
                
                sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
                List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
                String strDeptCd = YetaUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
                sysComBass0350Dto.setDeptCd(strDeptCd);
                List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
                String strTypOccuCd = YetaUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
                sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
                
               // sysComBass0350Dto.setPyspGrdeCd(YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
                
                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                    
                    lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
                  //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                    
                    lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                        public void handleEvent(StoreEvent<BaseModel> be) {  
                            mDtalistDtilOccuInttnCd = YetaUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
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

/**
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
* 검색 함수 선언부 종료
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
**/   
	  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 그리드 처리 함수 시작 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 	 
	private void createCheckBoxGrid() {

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("원천징수부출력대상자정보");
		fieldSet.setStyleAttribute("marginTop", "10px");

		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(950, 495);

		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		msfGridPanel = new MSFGridPanel(yeta4000def, false, false, false,false, false);
		msfGridPanel.setHeaderVisible(false);
		msfGridPanel.setBodyBorder(true);
		msfGridPanel.setBorders(true);
		// payr0301GridPanel.setSize(935, 440);
		// msfGridPanel.setMSFFormPanel(msfCustomForm); //폼을 그리드에 넣은다.

		cpGrid.add(msfGridPanel);

		lcStdGrid.add(cpGrid);
		fieldSet.add(lcStdGrid);

		plFrmYeta7600.add(fieldSet);

	}
	  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 그리드 처리 함수 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 	  
		public void reload() {
			// TODO Auto-generated method stub
		    msfGridPanel.getMsfGrid().clearData();
		    
			IColumnFilter filters = null;
			msfGridPanel.getTableDef().setTableColumnFilters(filters);
			
			msfGridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
			msfGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			msfGridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		
			//20180305추가 
			msfGridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			msfGridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			
			String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
			msfGridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS); 
           
           String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
           msfGridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
         //  String strPyspGrdeCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
        //   payr0301GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
         //  String strDtilOccuInttnCd = YetaUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
        //   payr0301GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
        
           
			//payr0301GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 		
			//payr0301GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//payr0301GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
			msfGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			msfGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		  	msfGridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		 	msfGridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
			
			msfGridPanel.reload();
		}
	  
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Yeta7600 getThis() {
		return this;
	}
	
	//엑셀 저장
	private void excelFileExport() {
		                     
		HashMap<String, String> param = new HashMap<String, String>(); 
		
		param.put("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr")); 
		param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));

		param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")); 
	
		String strDeptCd = YetaUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		param.put("deptCd", strDeptCd); 
       
       String strTypOccuCd = YetaUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
       param.put("typOccuCd", strTypOccuCd); 
       param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")); 
       param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue())); 
       param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));    
       param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));   
		   
       msfGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsYeta7600Export.do","extgwtFrame" ,param);                      
					           
	}
	
	   
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
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
