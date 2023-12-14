 package com.app.exterms.insurance.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.form.defs.Insr4300Def;
import com.app.exterms.insurance.client.service.Insr3200Service;
import com.app.exterms.insurance.client.service.Insr3200ServiceAsync;
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
import com.app.smrmf.core.resources.client.Resources;
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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

public class Insr3200  extends MSFPanel {   
	 
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
		 
	  private VerticalPanel vp;
	  private FormPanel plFrmInsr3200;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  //권한 설정 객체 
	  private GWTAuthorization gwtAuthorization;
	  private GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	  
	  //국민연금
	  private Insr4300Def insr4300Def  = new Insr4300Def("INSR3200");   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel insr4300GridPanel;
       
      //직종콤보
//	  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//	  private MSFGridPanel typOccuCdGridPanel;
	   
	  

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
     private ButtonBar topInsr3200Bar;
     private Button btnInsr3200Init;
     private Button btnInsr3200Save;
     private Button btnInsr3200Del;
     private Button btnInsr3200Sreach;
     private Button btnInsr3200TotInCome;
     private Button btnInsr3200Excel;

     /**
      * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      * 검색변수 선언 
      * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
      */
     

     /** column  년도 : year */
     private ComboBox<BaseModel> srhAntyDeinYr;
     
    
   //  private ComboBox<BaseModel> srhTypOccuCd; //직종 
   //  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
   //  private HiddenField<String> srhPyspGrdeCd; //직종 
     
   
     private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
     private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
     
     private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
   //  private TextField<String> srhDeptCd; //부서코드
   //  private TextField<String> srhDeptNm; //부서명  
   //  private Button btnSrhDeptCd;
   //  private TextField<String> srhMangeDeptCd; //관리부서 수정
   //  private TextField<String> srhMangeDeptNm; //관리부서 수정  
     private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정 
 	
     private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
     private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
     private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
     
     private ComboBox<BaseModel> srhBusinCd;    //사업
     private TextField<String> srhHanNm;         //성명
     private TextField<String> srhResnRegnNum;   //주민번호 
     private HiddenField<String> srhSystemkey;   //시스템키
     
     private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
     private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
     
     /** column 지급공제구분코드 : pymtDducDivCd */
     private ComboBox<BaseModel> srhPymtDducDivCd;
     
     
     private List<ModelData> mDtalistHdofcCodtnCd ;
     private List<ModelData> mDtalistDeptCd ;
     private List<ModelData> mDtalistTypOccuCd ;
     private List<ModelData> mDtalistDtilOccuInttnCd ;
     
     private boolean mutilCombo = false;
     private Boolean emptyCheck = false ;
     
     private ComboBox<BaseModel> srhChkAntyDeinYr;    //신고/결정구분으로 데이타가져오기 
     
     
     
     /** 
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
  		  private void checkInsr3200Auth( String authAction, ListStore<BaseModel> bm) {   
  	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
  			 
  			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {

  				  
 	                //----------------------------------------------------
				   if (!maskTracker) { unmask(); }  
 	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
  			   }
  		  }
  		  
  		 private void authExecEnabled() { 
  		    //----------------------------------------------------
             Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
             
             gwtAuthorization.formAuthFieldConfig(fldArrField);
            
              
             srhAntyDeinYr.setValue(lsAntyDeinYrStore.findModel("year",PayGenConst.ACC_CURR_YEAR));
             srhChkAntyDeinYr.setValue(lsChkAntyDeinYr.getAt(0));  
             
              srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
             srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
             
			 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 시작 
               * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			// gwtAuthorization.formAuthConfig(plFrmInsr3200, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
              /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
               * 권한설정을 위한 콤보처리를 위한 메서드 종료
               ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
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
  			     authMapDef.put("srhAntyDeinYr",Boolean.FALSE);
  			     authMapDef.put("srhHdofcCodtnCd",Boolean.FALSE);
  			     
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
//   	  private void checkInsr3200Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//       	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//   		 
//   		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//   		   
//   			 
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
	    private Insr3200ServiceAsync insr3200Service = Insr3200Service.Util.getInstance();	    
	 
       private ListStore<BaseModel> lsAntyDeinYrStore = new ListStore<BaseModel>();  //년도 
 		private ListStore<BaseModel> lsChkAntyDeinYr = new ListStore<BaseModel>();  //신고/결정 
 		 
 		
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
 		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
 		
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
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
* 	Rpc Service 선언부 종료
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
**/
/**
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
* 	print Service 선언부 시작
*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
**/
	private void InsrP3200Print(String fileName) {

		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "INSR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		 
		//검색조건
  	String serarchParam = ""; 
  	
  	//신고인경우에만 출력 가능하도록 처리 
  	String chkAntyDeinYr = InsrUtils.getSelectedComboValue(srhChkAntyDeinYr,"chkAntyDeinYr");
    
  	if ("01".equals(chkAntyDeinYr)) {
  	   MessageBox.info("", "결정년도가 확정된 내역 조회시에는 소득총액신고내역을 인쇄하실 수 없습니다.", null);
  		return;
  	}

	 String antyDeinYr = InsrUtils.getSelectedComboValue(srhAntyDeinYr,"year");
     
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
	
	String payrMangDeptCd =  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
	String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
	String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
	String typOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
	String pyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");
	//String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
	String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
	String hdofcCodtnCd = strHdofcCodtnCd;
	String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue());
	String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
	String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()); 
    
		 
	serarchParam += "["+antyDeinYr+"]";
	serarchParam += "["+payrMangDeptCd+"]";
	serarchParam += "["+emymtDivCd+"]";
	serarchParam += "["+typOccuCd+"]";
	serarchParam += "["+pyspGrdeCd+"]";
	serarchParam += "[]";
	serarchParam += "["+businCd+"]";
	
	serarchParam += "["+hdofcCodtnCd+"]";
	  
	//List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
	String checkedSystemKeys = "";
//				if(list != null && list.size() > 0){
//					String chkkey = "";
//					for(BaseModel bm : list){
//						chkkey += "'"+bm.get("systemkey")+"',";
//					}
//					
//					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//					
//				}
		serarchParam += "["+systemkey+"]";
		
		String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
		
		
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
      	        createInsr3200Form();  //화면 기본정보를 설정
      	        createSearchForm();    //검색필드를 적용
      	        createCheckBoxGrid();   
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
	  
	  
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createInsr3200Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createCheckBoxGrid();   
//	 
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }

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
	   *  @wbp.parser.constructor
	   */
	  public Insr3200() { 
		   
		   
			setSize("1010px", "700px");  
	  } 
	
	  public Insr3200(String txtForm) {
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
	  
	  private void createInsr3200Form() {
		  
			plFrmInsr3200 = new FormPanel();
			plFrmInsr3200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 국민연금보수총액신고"));
			plFrmInsr3200.setIcon(Resources.APP_ICONS.text());
			plFrmInsr3200.setBodyStyleName("pad-text");
			plFrmInsr3200.setPadding(2);
			plFrmInsr3200.setFrame(true);  

			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage("국민연금보수총액신고","INSR3200");
					}
				});
			plFrmInsr3200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmInsr3200.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

			
			   //멀티콤보박스 닫기 
			plFrmInsr3200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
	            @Override
	            public void handleEvent(ComponentEvent ce) { 
	            
	             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                       
	            //        if (f instanceof MSFMultiComboBox<?>) {
	                        
//	                        if ("srhDeptCd".equals(f.getName())) {
//	                            
//	                        } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//	                            
//	                        }
                           
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
			
		      topInsr3200Bar = new ButtonBar();    
				topInsr3200Bar.setAlignment(HorizontalAlignment.RIGHT);
	   
			  
				btnInsr3200Init = new Button("초기화");  
			    btnInsr3200Init.setIcon(Resources.APP_ICONS.new16());
			    topInsr3200Bar.add(btnInsr3200Init);
			    btnInsr3200Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		        });  
			  	 
			    
		  	    btnInsr3200Sreach = new Button("조회"); 
		  	    btnInsr3200Sreach.setIcon(Resources.APP_ICONS.search16());
		  	    topInsr3200Bar.add(btnInsr3200Sreach);
		  	    btnInsr3200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
		  	    
		  	    btnInsr3200Save = new Button("소득총액신고");  
			    btnInsr3200Save.setIcon(MSFMainApp.ICONS.print16());
		        topInsr3200Bar.add(btnInsr3200Save); 
		        btnInsr3200Save.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			InsrP3200Print("INSRT3200");
		    		}
		    	});
		  	
		  	    btnInsr3200Excel = new Button("엑셀"); 
		  	    btnInsr3200Excel.setIcon(Resources.APP_ICONS.excel16()); 
		  	    topInsr3200Bar.add(btnInsr3200Excel);  
		    	  btnInsr3200Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//엑셀저장  
		    			xlsExportData();
		    		}
		    	});
		    	   
		  	
		  	plFrmInsr3200.add(topInsr3200Bar);    
		  	
			//파일업로드 처리
			plFrmInsr3200.setAction("bizform");
			plFrmInsr3200.setEncoding(Encoding.MULTIPART);
			plFrmInsr3200.setMethod(Method.POST);
			
		
			vp.add(plFrmInsr3200);
			plFrmInsr3200.setSize("990px", "680px");
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
			 //재직상태  
			 sysComBass0300Dto.setRpsttvCd("A003");
			 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
	              public void handleEvent(StoreEvent<BaseModel> be) {  
	                  mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
	                  srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
	                  
	              }
	          });   
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //고용구분
			 sysComBass0300Dto.setRpsttvCd("A002");
			 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 
				//--------------------급여년도 불러 오는 함수 ------------------------------------------------
	         lsAntyDeinYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
			 //--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
	         


	         sysComBass0300Dto.setRpsttvCd("A048");
	         lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	         
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //결정/신고 
	         final ArrayList<BaseModel> bmList = new ArrayList<BaseModel>();
	         BaseModel bmChkAntyDeinYr = new BaseModel(); 
	         bmChkAntyDeinYr.set("chkAntyDeinYr", "01");
	         bmChkAntyDeinYr.set("chkAntyDeinYrDisp", "결정");
	         bmList.add(bmChkAntyDeinYr);
	         bmChkAntyDeinYr = new BaseModel(); 
	         bmChkAntyDeinYr.set("chkAntyDeinYr", "02");
	         bmChkAntyDeinYr.set("chkAntyDeinYrDisp", "신고");
	         bmList.add(bmChkAntyDeinYr);
	         
	         
	         lsChkAntyDeinYr.add(bmList); 
	         
	         
			// lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
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
	          //--------------------급여부서 불러 오는 함수 ------------------------------------------------
	          
			// sysComBass0400Dto.setDeptDspyYn("Y");
			 //--------------------부서 불러 오는 함수 ------------------------------------------------
			// lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
			 //--------------------부서 불러 오는 함수 ------------------------------------------------
			// sysComBass0400Dto.setDeptDspyYn("");
				
		   /**
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		      * 직종 콤보박스 처리  시작
		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
		      */
//		     		  ContentPanel typOccuCdGrid = new ContentPanel();  
//		     		  typOccuCdGrid.setVisible(false);
//		     		    
//		     		    //직종 콤보처리 
//		     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
//		     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		     			       public void handleEvent(ComponentEvent be) {  
//		     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		     			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		     			        	  
//		     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
//		     			        	mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
//	                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//		     			          }  
//		     			        });  
//		     			       
//		     			      }  
//		     			    });  
//		     	  
//		     		 typOccuCdGrid.add(typOccuCdGridPanel); 
//		     		plFrmInsr3200.add(typOccuCdGrid);
		     	    
	          lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
    		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
   	            public void handleEvent(StoreEvent<BaseModel> be) {  
   	             
                     mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                     srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                      
                   }
               });  
		  
		    plFrmInsr3200.setLayout(new FlowLayout());
		    
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
		  //  lcSchLeft.setStyleAttribute("paddingRight", "10px");
		   
		 
		    fieldSet.add(lcSchCol, new FormData("100%"));  
		    lcSchLeft.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch);
		    
		    srhAntyDeinYr = new ComboBox<BaseModel>();
		    srhAntyDeinYr.setName("srhAntyDeinYr");
		    srhAntyDeinYr.setForceSelection(true);
		    srhAntyDeinYr.setMinChars(1);
		    srhAntyDeinYr.setDisplayField("yearDisp");
		    srhAntyDeinYr.setValueField("year");
		    srhAntyDeinYr.setTriggerAction(TriggerAction.ALL);
		   // srhAntyDeinYr.setEmptyText("--년도선택--");
		    srhAntyDeinYr.setSelectOnFocus(true); 
		    srhAntyDeinYr.setReadOnly(false);
		    srhAntyDeinYr.setEnabled(true); 
		    srhAntyDeinYr.setStore(lsAntyDeinYrStore);
		    srhAntyDeinYr.setFieldLabel("결정년도"); 
		    srhAntyDeinYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
               public void handleEvent(StoreEvent<BaseModel> be) {  
            	checkInsr3200Auth("srhAntyDeinYr", lsAntyDeinYrStore); 
               	 
                 
               }
           });
		    srhAntyDeinYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		           BaseModel bmAntyDeinYr =  se.getSelectedItem(); 
		           if (bmAntyDeinYr != null) {
		               
		               if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                       
	                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                          
	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhAntyDeinYr,"year"));
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
		    layoutContainer_8.add(srhAntyDeinYr, new FormData("100%"));
		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		    layoutContainer_8.setBorders(false);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_9.setLayout(frmlytSch);
		     
		 
		    srhChkAntyDeinYr = new ComboBox<BaseModel>();
		    srhChkAntyDeinYr.setName("srhChkAntyDeinYr");
		    srhChkAntyDeinYr.setForceSelection(true);
		    srhChkAntyDeinYr.setMinChars(1);
		    srhChkAntyDeinYr.setDisplayField("chkAntyDeinYrDisp");
		    srhChkAntyDeinYr.setValueField("chkAntyDeinYr");
		    srhChkAntyDeinYr.setTriggerAction(TriggerAction.ALL);
		   // srhPayMonth.setEmptyText("--월선택--");
		    srhChkAntyDeinYr.setSelectOnFocus(true); 
		    srhChkAntyDeinYr.setReadOnly(false);
		    srhChkAntyDeinYr.setEnabled(true); 
		    srhChkAntyDeinYr.setStore(lsChkAntyDeinYr);
		    srhChkAntyDeinYr.setHideLabel(true);
		    srhChkAntyDeinYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
               public void handleEvent(StoreEvent<BaseModel> be) {    
               	btnInsr3200Save.setEnabled(false);
               }
           });
		    //srhAntyDeinYr
		    
		    srhChkAntyDeinYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
		           BaseModel bmChkAntyDeinYr =  se.getSelectedItem(); 
		           if (bmChkAntyDeinYr != null) {
		                //소득총액신고 인쇄버튼 활성화
		        	   String chkAntyDeinYr = MSFSharedUtils.allowNulls(bmChkAntyDeinYr.get("chkAntyDeinYr"));
		        	   
		        	   //Window.alert(""+chkAntyDeinYr);
		        	   
		        	   if ("01".equals(chkAntyDeinYr)) {
		        		   btnInsr3200Save.setEnabled(false);
		        	   } else {
		        		   btnInsr3200Save.setEnabled(true);
		        	   }
		              
		           }       
		          } 
		      });   
		    layoutContainer_9.add(srhChkAntyDeinYr, new FormData("100%"));
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
	        srhPayrMangDeptCd.setReadOnly(false);
	        srhPayrMangDeptCd.setEnabled(true); 
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
			                	checkInsr3200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
	        srhEmymtDivCd.setReadOnly(false);
	        srhEmymtDivCd.setEnabled(true); 
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
	        			checkInsr3200Auth("srhEmymtDivCd", lsEmymtDivCd); 
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

	        		//			       	  EventType type = be.getType();
	        		//				    	   if (type == Store.Add) { 
	        		//			           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        		//				                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
	        		//				                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
	        		//				                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
	        		//				                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	        		//				    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
	        		//			           	 }  

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
	        srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
	            public void handleEvent(StoreEvent<ModelData> be) {  
	            	 EventType type = be.getType();
			    	   if (type == Store.Add) { 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	checkInsr3200Auth("srhDeptCd", lsDeptCd); 
	                	 }
	            
	            }
	        });    
	 
	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	           @Override
	          public void handleEvent(ComponentEvent ce) { 
	                   
	                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                         
	                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                             
	                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhAntyDeinYr,"year"));    
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
	               
	                //new SelectionChangedListener<ModelData>() {
	         //@Override
	         //public void selectionChanged(SelectionChangedEvent<ModelData> se) {
	         //.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
	         //  public void selectionChanged(SelectionChangedEvent<ModelData> se) {
	            
	                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	             BaseModel bmPayCd =  se.getSelectedItem(); 
//	             if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//	                 if (bmPayCd != null) {  
//	                    
//	                     sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
//	                     sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
//	                 }      
//	              
//	                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                   lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                  //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                   srhBusinCd.setStore(lsBusinCd); 
//	                   srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                       public void handleEvent(StoreEvent<BaseModel> be) {  
//	                        //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                       }
//	                   });    
//	             
//	             }  
	            
	            } 
	        });
		    //검색 소속부서 코드 처리  
//	        LayoutContainer lccmlcDeptNm = new LayoutContainer();
//	        lccmlcDeptNm.setLayout(new ColumnLayout());
//	           //부서 
//	        srhDeptCd = new TextField<String>();
//	        srhDeptCd.setName("srhDeptCd");
//	        srhDeptCd.setVisible(false);
//	        srhDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
//	            @Override
//	            public void handleEvent(BaseEvent be) { 
//	              if(srhDeptCd.getValue() != null){ 
//	                 
//	                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//	                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhAntyDeinYr,"year")); 
//	                      sysComBass0500Dto.setDeptCd(srhDeptCd.getValue()); 
//	                  
//	                    //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                     //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                      srhBusinCd.setStore(lsBusinCd); 
//	                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                          public void handleEvent(StoreEvent<BaseModel> be) {  
//	                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                          }
//	                      });    
//	                 
//	              } 
//	            }
//	         });
//	        plFrmInsr3200.add(srhDeptCd);
//	        srhMangeDeptCd = new TextField<String>();
//	        srhMangeDeptCd.setName("srhMangeDeptCd");
//	        srhMangeDeptCd.setVisible(false);
//	        plFrmInsr3200.add(srhMangeDeptCd);
//	        srhMangeDeptNm = new TextField<String>();
//	        srhMangeDeptNm.setName("srhMangeDeptNm");
//	        srhMangeDeptNm.setVisible(false);
//	        plFrmInsr3200.add(srhMangeDeptNm);
	//  
//	         LayoutContainer lcDeptNm = new LayoutContainer(); 
//	         frmlytSch = new FormLayout();
//	         frmlytSch.setLabelWidth(70);
//	         frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//	         lcDeptNm.setLayout(frmlytSch);
//	      
//	         srhDeptNm = new TextField<String>();
//	         srhDeptNm.setName("srhDeptNm");
//	         srhDeptNm.setFieldLabel("부서");  
//	         srhDeptNm.addKeyListener(new KeyListener() {
//	              public void componentKeyUp(ComponentEvent event) {
//	                  super.componentKeyUp(event); 
//	                  if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                      if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                          srhDeptCd.setValue("");
//	                          srhMangeDeptCd.setValue("");
//	                      }
//	                      fnPopupCommP140(srhDeptNm.getValue());
//	                  }
//	              }
//	          });
//	         
//	         srhDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	                    @Override
//	                    public void handleEvent(BaseEvent be) { 
//	                         
//	                        if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                            srhDeptCd.setValue("");
//	                            srhMangeDeptCd.setValue("");
//	                        }
//	                     
//	                    } 
//	           });        
//	          lcDeptNm.add(srhDeptNm, new FormData("100%"));  
//	          
//	           btnSrhDeptCd = new Button();
//	           btnSrhDeptCd.setIcon(MSFMainApp.ICONS.search()); 
//	           btnSrhDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//	               public void handleEvent(ButtonEvent e) { 
//	                   if (MSFSharedUtils.allowNulls(srhDeptCd.getValue()).trim().equals("")) {
//	                       srhDeptCd.setValue("");
//	                       srhMangeDeptCd.setValue("");
//	                   }
//	                   fnPopupCommP140(srhDeptNm.getValue()); 
//	               }
//	           });
//	            
//	           lccmlcDeptNm.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
//	           lccmlcDeptNm.add(btnSrhDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	             
		    layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		    layoutContainer_2.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_10.setLayout(frmlytSch);
	        
//	        srhTypOccuCd =  new ComboBox<BaseModel>(); 
//	        srhTypOccuCd.setName("srhTypOccuCd");
//	        srhTypOccuCd.setForceSelection(true);
//	        srhTypOccuCd.setMinChars(1);
//	        srhTypOccuCd.setDisplayField("typOccuNm");
//	        srhTypOccuCd.setValueField("typOccuCd");
//	        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	        srhTypOccuCd.setEmptyText("--직종선택--");
//	        srhTypOccuCd.setSelectOnFocus(true); 
//	        srhTypOccuCd.setReadOnly(false);
//	        srhTypOccuCd.setEnabled(true); 
//	        srhTypOccuCd.setStore(lsTypOccuCd);
//	        srhTypOccuCd.setFieldLabel("직종");
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
	 	   frmlytSch.setLabelWidth(1); 
	 	   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	 	   frmlytSch.setDefaultWidth(0);
	 	   layoutContainer_21.setLayout(frmlytSch);
	        
//	        srhTypOccuCd = new ComboBox<BaseModel>(); 
//	        srhTypOccuCd.setName("srhTypOccuCd");
//	        srhTypOccuCd.setForceSelection(true);
//	        srhTypOccuCd.setMinChars(1);
//	        srhTypOccuCd.setDisplayField("typOccuNm");
//	        srhTypOccuCd.setValueField("typOccuCd");
//	        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//	        srhTypOccuCd.setEmptyText("--직종선택--");
//	        srhTypOccuCd.setSelectOnFocus(true); 
//	        srhTypOccuCd.setReadOnly(false);
//	        srhTypOccuCd.setEnabled(true); 
//	        srhTypOccuCd.setStore(lsTypOccuCd); 
//	        srhTypOccuCd.setFieldLabel("직 종");  
//	        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                //직종변경에 따른 직종세 값 가져오기
//	                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
//	                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//	                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//	                    sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//	                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
//	                        LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//	                        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//	                    }
//	                }
//	            } 
//	        }); 
//	        lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
 
//	              
//	                
//	            }
//	        });    
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	    	srhTypOccuCd.setHideLabel(true);
	        //srhTypOccuCd.setFieldLabel("직종");
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
			               // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	//checkInsr3200Auth("srhTypOccuCd", lsTypOccuCd); 
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
//	        srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//	        srhDtilOccuInttnCd.setForceSelection(true);
//	        srhDtilOccuInttnCd.setMinChars(1);
//	        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//	        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//	        srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//	        srhDtilOccuInttnCd.setSelectOnFocus(true); 
//	        srhDtilOccuInttnCd.setReadOnly(false);
//	        srhDtilOccuInttnCd.setEnabled(true);  
//	        srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//	      //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//	        srhDtilOccuInttnCd.setLabelSeparator("");
	       
	        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
	        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
	        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
	        srhDtilOccuInttnCd.setWidth(100);
	        srhDtilOccuInttnCd.setHideLabel(true);
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
		    
//		    LayoutContainer layoutContainer_3 = new LayoutContainer();
//		    layoutContainer_3.setLayout(new ColumnLayout());
//		    
//		   
//		     
//		    fieldSet.add(layoutContainer_3);
//		    layoutContainer_3.setBorders(false);
			
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
//			    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			        @Override
//			        public void handleEvent(BaseEvent be) {  
//			            if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//			                srhSystemkey.setValue("");
//			                srhResnRegnNum.setValue("");
//			            }
//			         
//			        } 
//			   }); 
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
			                srhHanNm.setValue("");
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
		        //	        srhHdofcCodtnCd.setForceSelection(true);
//		        srhHdofcCodtnCd.setMinChars(1);
//		        srhHdofcCodtnCd.setDisplayField("commCdNm");
//		        srhHdofcCodtnCd.setValueField("commCd");
		       // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
		        srhHdofcCodtnCd.setEmptyText("--재직선택--");
//		        srhHdofcCodtnCd.setSelectOnFocus(true); 
		        srhHdofcCodtnCd.setReadOnly(true);
		        srhHdofcCodtnCd.setEnabled(true); 
		       // srhHdofcCodtnCd.setStore(lsHdofcCodtnCd); 
		        srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
		        srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		        srhHdofcCodtnCd.setWidth(100);
		     //   srhHdofcCodtnCd.setHeight(100);
		        srhHdofcCodtnCd.setFieldLabel("재직상태");
		        srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
		            public void handleEvent(StoreEvent<ModelData> be) {  
		            	checkInsr3200Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);  
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
			    
		    plFrmInsr3200.add(fieldSet); 
		//vp.add(panel);   
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
//		  List<Stock> stocks = null; //TestData.getStocks();   
//		    
//		    RowNumberer r = new RowNumberer();   
//
//		    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();   
//		    configs.add(r);   
//
//		    final CheckBoxSelectionModel<Stock> sm = new CheckBoxSelectionModel<Stock>();   
//		    // selection model supports the SIMPLE selection mode   
//		    // sm.setSelectionMode(SelectionMode.SIMPLE);   
//		  
//		    configs.add(sm.getColumn());   
//		  
//		    ColumnConfig column = new ColumnConfig();   
//		    column.setId("name");   
//		    column.setHeaderText("부서");  
//		    column.setAlignment(HorizontalAlignment.CENTER); 
//		    column.setWidth(100);   
//		    configs.add(column);   
//		  
//	 
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("성 명");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("주민등록번호");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("등급");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		    
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("근무월수");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    column = new ColumnConfig("change", "소득총액", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig("change", "표준소득총액", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig();   
//		    column.setId("last");   
//		    column.setHeaderText("자격취득일자");   
//		    column.setAlignment(HorizontalAlignment.CENTER);   
//		    column.setWidth(100);   
//		    column.setRenderer(gridNumber);   
//		    configs.add(column);   
//		  
//		    column = new ColumnConfig("change", "직종(사업)", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);   
//		    
//		    column = new ColumnConfig("change", "직종세", 100);   
//		    column.setAlignment(HorizontalAlignment.CENTER);    
//		    column.setRenderer(change);   
//		    configs.add(column);
//		    
//		    
//		    ListStore<Stock> store = new ListStore<Stock>();   
//		    store.add(stocks);   
//		  
//		    ColumnModel cm = new ColumnModel(configs);    
//		    
//		    ContentPanel cp = new ContentPanel();   
//		    cp.setHeaderVisible(false);
//		    cp.setFrame(true);   
//		    cp.setIcon(Resources.APP_ICONS.table());   
//		    cp.setLayout(new FitLayout());   
//		    cp.setSize(600, 300);   
//		  
//		    Grid<Stock> grid = new Grid<Stock>(store, cm);   
//		    grid.setSelectionModel(sm);   
//		    grid.setBorders(true);   
//		    grid.setColumnReordering(true);   
//		    grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");   
//		    grid.addPlugin(sm);   
		      
		  
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("소득총액내역");
		    fieldSet.setStyleAttribute("marginTop", "10px");
		    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		   // lcStdGrid.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(950, 480);  
		    
		    //msfCustomForm.setHeaderVisible(false);
		    //Instantiate the GridPanel
		    insr4300GridPanel = new MSFGridPanel(insr4300Def, false, false, false, false);
		    insr4300GridPanel.setHeaderVisible(false);  
		    insr4300GridPanel.setBodyBorder(true);
		    insr4300GridPanel.setBorders(true);
			//   insr4300GridPanel.setSize(308, 466); 
		 //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.

		    cpGrid.add(insr4300GridPanel);  
		    lcStdGrid.add(cpGrid);   
		    fieldSet.add(lcStdGrid);   
	      
	        plFrmInsr3200.add(fieldSet);
	     
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
			insr4300GridPanel.getTableDef().setTableColumnFilters(filters);
				
			insr4300GridPanel.getTableDef().addColumnFilter("antyDeinYr", (MSFSharedUtils.getSelectedComboValue(srhAntyDeinYr,"year")), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr4300GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			insr4300GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			insr4300GridPanel.getTableDef().addColumnFilter("chkAntyDeinYr", MSFSharedUtils.getSelectedComboValue(srhChkAntyDeinYr,"chkAntyDeinYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
			 
	 
	            String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	            insr4300GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	           
	            //20180305추가 
	            insr4300GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	            insr4300GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 

	            String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	            insr4300GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//	            String strPyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//	            insr4300GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
	            String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	            insr4300GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	          
				//insr4300GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				//insr4300GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				//insr4300GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd") , SimpleColumnFilter.OPERATOR_EQUALS); 
				//insr4300GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	          
	            insr4300GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	            insr4300GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
	            insr4300GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
	            insr4300GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
				 
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
			   insr4300GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	              
				 
			   insr4300GridPanel.reload();
				
			
			actionDatabase = ActionDatabase.READ; 
		}
		
		
		//폼초기화 검색조건포함 
	   private void formInit() {
		     
	 
		   insr4300GridPanel.getMsfGrid().clearData();
		   
	   }		 
     

 public void setRecord(BaseModel record) {
      this.record = record;
  }


  private Insr3200 getThis(){
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

 private void xlsExportData() { 
	 	 
	 	
       //  MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>(){
         //    @Override
         //    public void handleEvent(MessageBoxEvent be) {
         //        if("Yes".equals(be.getButtonClicked().getText())){
                     
	  				  HashMap<String, String> param = new HashMap<String, String>(); 
  
	  
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
				      
					   param.put("antyDeinYr", InsrUtils.getSelectedComboValue(srhAntyDeinYr,"year"));
					   //신고인경우에만 출력 가능하도록 처리 
					   param.put("chkAntyDeinYr", InsrUtils.getSelectedComboValue(srhChkAntyDeinYr,"chkAntyDeinYr"));
						
			           param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
			           param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
			           param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
			           param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
			           param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
			           param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
			           param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			           param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
			           param.put("hdofcCodtnCd", strHdofcCodtnCd);
			           param.put("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()));
			           param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
			           param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())); 
                     
                     
                     
                     if("".equals(InsrUtils.getSelectedComboValue(srhAntyDeinYr,"year")) ){
                         MessageBox.info("", "결정년도는 필수 입니다.", null);
//                     } else if("".equals(payCd)){
//                         MessageBox.info("", "급여구분은 필수 입니다.", null);
//                     }else if("".equals(workDayS) || "".equals(workDayE)){
//                         MessageBox.info("", "근태기간은 필수 입니다.", null);
//                         
//                     } else  if (MSFConfiguration.EMYMT_DIVCD02.equals(emymtDivCd)) {
//                   	  
//                   	  if("".equals(businCd)){ 
//                    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//             	                         "사업명을 선택하십시요.", null);
//                      		 
//              		     } else { 
//                        
//                         insr4300GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr3100TempExport.do","extgwtFrame" ,param);   
//              		     }
                     }else{  
                   	  insr4300GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr3200Export.do","extgwtFrame" ,param);  
                     }
           //      }
       //      }
             
      //   });
          
         
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
