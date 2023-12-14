package com.app.exterms.insurance.client.form;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3100DTO;
import com.app.exterms.insurance.client.form.defs.Insr3100Def;
import com.app.exterms.insurance.client.service.Insr4500Service;
import com.app.exterms.insurance.client.service.Insr4500ServiceAsync;
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
public class Insr4500  extends MSFPanel { 
 

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	private HiddenField<String> systemkey;   				//시스템키
	
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
	private FormPanel plFrmInsr4500; 
	private String txtForm = "";
	private XTemplate detailTp;
	
	//권한 설정 객체 
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리
	  
	private Insr3100Def insr3100Def  = new Insr3100Def("INSR4500");   //그리드 테이블 컬럼 define  
	private MSFGridPanel insr3100GridPanel;
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
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel> srhPayMonth;
      private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 
      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
      private MSFMultiComboBox<ModelData> srhHdofcDivCd; //재직구분
      private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuClsDivCd; //직종세
      private ComboBox<BaseModel> srhBusinCd;    //사업
      private TextField<String> srhNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
      
      /** column 지급공제구분코드 : pymtDducDivCd */
      private ComboBox<BaseModel> srhPymtDducDivCd;
      private List<ModelData> mDtalistHdofcCodtnCd ;
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuClsDivCd ;
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
	private HiddenField<String> dilWrkrIncmBlggYr;   /** column 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
	private HiddenField<String> dilWrkrBlggQatrDivCd;   /** column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
	private TextField<String> corpNmFmnm;   /** column 법인명_상호 : corpNmFmnm */
	private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
	private ComboBox<BaseModel> pentrCd;   /** column 제출자구분코드 : pentrCd */
	private TextField<String> txDeptyNum;   /** column 세무대리인번호 : txDeptyNum */
	private TextField<String> hmtxId;   /** column 홈텍스ID : hmtxId */
	private TextField<String> pernChrgDeptNm;   /** column 담당자부서명 : pernChrgDeptNm */
	private TextField<String> pernChrgNm ;  /** column 담당자성명 : pernChrgNm */
	private TextField<String> pernChrgPhnNum;   /** column 담당자전화번호 : pernChrgPhnNum */ 

	private Boolean emptyCheck = false ;
	// --------------- 대상자 업로드 ---------------
	private FileUploadField insr4500flUp;
	private Boolean picBoolFile;
	
	private Insr4500ServiceAsync insr4500Service = Insr4500Service.Util.getInstance();
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
     
     /**
  		   * 권한설정 처리 체크 
  		   * AuthAction 
  		   */
  		  private void checkInsr4500Auth( String authAction, ListStore<BaseModel> bm) {   
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
			Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuClsDivCd, srhBusinCd};
			gwtAuthorization.formAuthFieldConfig(fldArrField);
			
			srhPayYr.setValue(lsPayYrStore.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));
			srhPayMonth.setValue(lsPayMonth.findModel("month", DateTimeFormat.getFormat("MM").format(new Date())));
			
			srhHdofcDivCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true);
			srhHdofcDivCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
				  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	                * 권한설정을 위한 콤보처리를 위한 메서드 시작 
	                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
	                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
	                // GWTAuthorization.formAuthPopConfig(plFrmInsr4500, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuClsDivCd","srhBusinCd");
	                // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
				// gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuClsDivCd","srhBusinCd"); 
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
  			     authMapDef.put("srhPayYr",			 Boolean.FALSE);
			     authMapDef.put("srhPayMonth",		 Boolean.FALSE);
			     authMapDef.put("srhHdofcDivCd",	 Boolean.FALSE);
  			     authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
  			     authMapDef.put("srhEmymtDivCd",	 Boolean.FALSE);
  				 authMapDef.put("srhDeptCd",		 Boolean.FALSE);
  				 
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
	    private void setInsr4500FormBinding() {
	 	 
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
//	    private Insr4500ServiceAsync insr4500Service = Insr4500Service.Util.getInstance();	    
		 
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
  		private ListStore<BaseModel>  lsHdofcDivCd = new ListStore<BaseModel>(); //재직구분
  		
  		private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); //지급공제구분코드 
  		private ListStore<BaseModel>  lsDtilOccuClsDivCd = new ListStore<BaseModel>();//직종세
  		
  		private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
  		private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  
  		
  		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
  		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
  		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
  		private SysCoCalendarDTO  msfCoCalendarDto;  
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
private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
	public void componentSelected(ButtonEvent ce) {
		
	}
};

/* 버튼에 따른 Action */
private void doAction(ActionDatabase actionDatabase) {
	switch(actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			payRflctn();
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			payRflctn();
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			payRflctn();
			break;
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
	private void Insr4500Print(String fileName) {
 
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PAYR";
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
		// 보낼 파라미터
		
		
		//검색조건
 	   String serarchParam = "";
		String strParam = "/rp " + serarchParam; //+"["+checkedSystemKeys+"]";
		
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
  public Insr4500() {
	  
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

public Insr4500(String txtForm) {
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
	plFrmInsr4500 = new FormPanel();
	
//	plFrmInsr4500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Insr4400());
	plFrmInsr4500.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 연말정산산출내역반영"));
	plFrmInsr4500.setIcon(MSFMainApp.ICONS.text());
//	plFrmInsr4500.setBodyStyleName("pad-text");
	plFrmInsr4500.setFrame(true);
	
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
	 ************************************************************************/
	final Button btnlogView = new Button("로그");   
	
	btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
	btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			 //로그 뷰화면 호출 메서드 
			  funcLogMessage("연말정산산출내역반영","INSR4500");
			}
		});
	plFrmInsr4500.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
	plFrmInsr4500.getHeader().addTool(btnlogView); 
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 
	 ************************************************************************/
	
	// ------------------ 멀티콤보박스 닫기 ------------------  
	plFrmInsr4500.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
        @Override
        public void handleEvent(ComponentEvent ce) { 
        	if (mutilCombo) {
        		if ( srhDeptCd.getCheckBoxListHolder().isVisible()) {
        			//부서
        			srhDeptCd.showClose(ce);
        			mutilCombo = false;
        		} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
        			//직종
        			srhTypOccuCd.showClose(ce);
        			mutilCombo = false;
        		} else if ( srhDtilOccuClsDivCd.getCheckBoxListHolder().isVisible() ) {
        			//직종세
        			srhDtilOccuClsDivCd.showClose(ce);
        			mutilCombo = false;
        		}   else if ( srhHdofcDivCd.getCheckBoxListHolder().isVisible() ) {
        			// 재직
        			srhHdofcDivCd.showClose(ce);
        			mutilCombo = false;
        		} 
        	}
        } 
	}); 
	// ------------------ 멀티콤보박스 닫기 ------------------  
	
	

	
	ButtonBar buttonBar = new ButtonBar();
	buttonBar.setAlignment(HorizontalAlignment.RIGHT);
	
	Button topBtn = new Button("초기화");
	topBtn.setIcon(MSFMainApp.ICONS.new16());
	buttonBar.add(topBtn);
	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			//초기화 버튼 클릭시 처리
			formInit();
		}
    });
	
	topBtn = new Button("조회");
	topBtn.setIcon(MSFMainApp.ICONS.search16());
	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
//			actionDatabase = ActionDatabase.UPDATE;
//			psnl0290Loader.load();
			reload();
		}
	});
	
	buttonBar.add(topBtn);
	
	topBtn = new Button("당월급여반영");
	topBtn.setIcon(MSFMainApp.ICONS.text()); 
	buttonBar.add(topBtn);
	topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
//			setListRecord(insr3100GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator());
			//setListRecord(insr3100GridPanel.getMsfGrid().getGrid().getStore().getModels().iterator());
			actionDatabase = ActionDatabase.UPDATE;
			doAction(actionDatabase);
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
	
	plFrmInsr4500.add(buttonBar);       
	
	//파일업로드 처리
	plFrmInsr4500.setAction("myurl");
	plFrmInsr4500.setEncoding(Encoding.MULTIPART);
	plFrmInsr4500.setMethod(Method.POST);
	
	vp.add(plFrmInsr4500);
	//엣지변환
	//plFrmInsr4500.setSize("990px", "680px");
	plFrmInsr4500.setSize("990px", "730px");
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
	msfCoCalendarDto  = new SysCoCalendarDTO();
	sysComBass0350Dto = new PrgmComBass0350DTO();
	sysComBass0320Dto = new PrgmComBass0320DTO();
	
	//--------------------단위기관 불러 오는 함수 ------------------------------------------------
	lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
	//--------------------단위기관 불러 오는 함수 ------------------------------------------------
	
	//--------------------공통 코드 불러 오는 함수 -----------------------------------------------
	//재직구분
	sysComBass0300Dto.setRpsttvCd("A003");
	lsHdofcDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	lsHdofcDivCd.addStoreListener( new StoreListener<BaseModel>() {
		public void handleEvent(StoreEvent<BaseModel> be) {
			mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcDivCd);
			srhHdofcDivCd.getStore().add(mDtalistHdofcCodtnCd);
		}
	});
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //고용구분
		 sysComBass0300Dto.setRpsttvCd("A002");
		 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //년도
		 lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		 //월 
		 
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
                  srhDeptCd.getStore().add(mDtalistDeptCd);
                  
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

		sysComBass0300Dto.setRpsttvCd("A048");
		lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		   
	    plFrmInsr4500.setLayout(new FlowLayout());
	    
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
//	    lcSchLeft.setStyleAttribute("paddingRight", "10px");
	   
	 
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
	    srhPayYr.setFieldLabel("정산년월"); 
	    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	        public void handleEvent(StoreEvent<BaseModel> be) {  
	     	   checkInsr4500Auth("srhPayYr",lsPayYrStore);  
	          
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
	     	   checkInsr4500Auth("srhPayMonth",lsPayMonth);  
	          
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
		                	checkInsr4500Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
		                	checkInsr4500Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
               srhDtilOccuClsDivCd.reset();
               srhDtilOccuClsDivCd.setEnabled(false);
  	    	 } else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
            	 //20151130 추가 수정 
        	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
            	 srhBusinCd.reset();
                 srhBusinCd.setEnabled(false);   
                 if (gwtExtAuth.getEnableTypOccuCd()) {
                	 srhTypOccuCd.setEnabled(true);
                     srhDtilOccuClsDivCd.setEnabled(true); 
                 } else {
                	 srhTypOccuCd.setEnabled(false);
                     srhDtilOccuClsDivCd.setEnabled(false);
                     
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
		                	checkInsr4500Auth("srhDeptCd", lsDeptCd); 
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
 		   frmlytSch.setLabelWidth(1); 
 		   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
 		   frmlytSch.setDefaultWidth(0);
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
	         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0);
		                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
		                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
	                }  
             		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkInsr4500Auth("srhTypOccuCd", lsTypOccuCd); 
		    		}
		    	}
                
            }
        });     
        
        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
           @Override
          public void handleEvent(ComponentEvent ce) { 
                   
        	   //2015.11.30 추가 
          	 displayDtilOccuClsDivCd(); 
          	  
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
            	
            	displayDtilOccuClsDivCd();
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
       
        srhDtilOccuClsDivCd = new MSFMultiComboBox<ModelData>();
        srhDtilOccuClsDivCd.setName("srhDtilOccuClsDivCd"); 
        srhDtilOccuClsDivCd.setEmptyText("--직종세선택--"); 
        srhDtilOccuClsDivCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
        srhDtilOccuClsDivCd.getStore().add(mDtalistDtilOccuClsDivCd);
        srhDtilOccuClsDivCd.setWidth(100);
        srhDtilOccuClsDivCd.setHideLabel(true);
        srhDtilOccuClsDivCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
        srhDtilOccuClsDivCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
        srhDtilOccuClsDivCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
        
        lcSchRight.add(srhDtilOccuClsDivCd, new FormData("100%")); 
        
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
//        srhNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(srhNm.getValue()).trim().equals("")) {
//                    srhSystemkey.setValue("");
//                    srhResnRegnNum.setValue("");
//                }
//             
//            } 
//       }); 
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
        
        srhHdofcDivCd = new MSFMultiComboBox<ModelData>(); 
        srhHdofcDivCd.setName("srhHdofcDivCd");
        srhHdofcDivCd.setEmptyText("--재직구분선택--");
        srhHdofcDivCd.setReadOnly(true);
        srhHdofcDivCd.setEnabled(true);
        srhHdofcDivCd.getListView().setDisplayProperty("commCdNm");
        srhHdofcDivCd.getStore().add(mDtalistHdofcCodtnCd);
        srhHdofcDivCd.setWidth(100);
        srhHdofcDivCd.setFieldLabel("재직구분");
        srhHdofcDivCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
            public void handleEvent(StoreEvent<ModelData> be) {  
            	checkInsr4500Auth("srhHdofcDivCd",lsHdofcDivCd); 
            }
        }); 
        srhHdofcDivCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
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
        
        layoutContainer_14.add(srhHdofcDivCd, new FormData("100%"));
       
        layoutContainer_14.setBorders(false);
        
	    lcSchCol3.setBorders(false); 
	    lcSchCol3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    lcSchCol3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	    lcSchCol3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
	    
	    
        fieldSet.add(lcSchCol3);
	    
	    plFrmInsr4500.add(fieldSet);
  }  

private void  displayDtilOccuClsDivCd() {
	  
	   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        
        //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
            
            sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
            List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
            String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                
                lsDtilOccuClsDivCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
                
                lsDtilOccuClsDivCd.addStoreListener( new StoreListener<BaseModel>() {   
                    public void handleEvent(StoreEvent<BaseModel> be) {  
                        mDtalistDtilOccuClsDivCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuClsDivCd) ; 
                        srhDtilOccuClsDivCd.getInitStore().add(mDtalistDtilOccuClsDivCd);
                        
                        if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
                    	    ModelData  mdSelect  = srhDtilOccuClsDivCd.getStore().getAt(0);
                    	    srhDtilOccuClsDivCd.getListView().setChecked(mdSelect, true); 
                    	    srhDtilOccuClsDivCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm"))); 
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
    LayoutContainer layoutContainer = new LayoutContainer();   

    ContentPanel cp01 = new ContentPanel();
    cp01.setHeaderVisible(false); 
    cp01.setSize(950, 450);
    cp01.setLayout(new FitLayout());
    
    LayoutContainer layoutContainer_16 = new LayoutContainer(); 
    layoutContainer_16.setLayout(new ColumnLayout());
    
    LayoutContainer layoutContainer_1 = new LayoutContainer();
    FormLayout frmlytStd = new FormLayout();  
    frmlytStd.setLabelWidth(0); 
    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    layoutContainer_1.setLayout(frmlytStd);
    
    FieldSet fldstNewFieldset = new FieldSet();
    fldstNewFieldset.setSize("958px", "450px");
    
    fldstNewFieldset.add(createCheckBoxGrid(),new FormData("100%"));
    layoutContainer_1.add(fldstNewFieldset);
    fldstNewFieldset.setHeadingHtml("대상자정보");
    fldstNewFieldset.setCollapsible(false);
    fldstNewFieldset.setStyleAttribute("marginTop", "10px");
    layoutContainer_16.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
    
     cp01.add(layoutContainer_16);
     layoutContainer_16.setSize("934", "450");
     layoutContainer.add(cp01) ;    
    
      
     fldstNewFieldset.add(layoutContainer,new FormData("100%"));    
    
    plFrmInsr4500.add(fldstNewFieldset);
    
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
	cpGrid.setSize(945, 430);
	
	insr3100GridPanel = new MSFGridPanel(insr3100Def, false, false, false, false, false);
	insr3100GridPanel.setHeaderVisible(false);
	insr3100GridPanel.setBodyBorder(true);
	insr3100GridPanel.setBorders(true);
	//Set the CustomForm to be used by the GridPanel
	
	/* 2줄파싱 */
	insr3100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 6,  new HeaderGroupConfig("부과한 총보험료", 1, 3));
    insr3100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 13, new HeaderGroupConfig("확정보험료",	  1, 3));
    insr3100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 16, new HeaderGroupConfig("정산보험료",	  1, 3));
    insr3100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 19, new HeaderGroupConfig("가입자부담금",	  1, 3));
	
	final Grid insr3100Grid = insr3100GridPanel.getMsfGrid().getGrid();
	insr3100Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
		public void handleEvent(BaseEvent be) {
			if(insr3100GridPanel.getCurrentlySelectedItem() != null) {
				insr3100GridPanel.getMSFFormPanel().bind(insr3100GridPanel.getCurrentlySelectedItem());
				setRecord(insr3100GridPanel.getCurrentlySelectedItem());
				if(actionDatabase == ActionDatabase.INSERT) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		}
	});
	
	cpGrid.add(insr3100GridPanel);
	lcStdGrid.add(cpGrid);
	
	return lcStdGrid;
}

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 


private void createBottom() {
	 
	FieldSet fldstNewFieldset = new FieldSet();	
	fldstNewFieldset.setHeadingHtml("건강보험산출내역업로드");
	
	LayoutContainer layoutContainer = new LayoutContainer();
	layoutContainer.setLayout(new FlowLayout(1));
	
	LayoutContainer layoutContainer_1 = new LayoutContainer();
	layoutContainer_1.setLayout(new ColumnLayout()); 
	
	LayoutContainer layoutContainer_2 = new LayoutContainer();
	layoutContainer_2.setStyleAttribute("paddingRight", "10px");
    FormLayout frmlytSch = new FormLayout();  
    frmlytSch.setLabelWidth(100); 
    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	layoutContainer_2.setLayout(frmlytSch);
	
	insr4500flUp = new FileUploadField();
	insr4500flUp.setName("insr4500flUp");
	insr4500flUp.setValidator(new Validator() {
		@Override
		public String validate(Field<?> field, String value) {
			value = value.toLowerCase();
			String result = "xls 파일이 아닙니다., 다시선택하십시요.";
			
			if(value.endsWith(".xls") || value.endsWith(".xlsx")){
				result = null;
			}
			return result;
		}
	});
	layoutContainer_2.add(insr4500flUp, new FormData("100%"));
	insr4500flUp.setFieldLabel("건강보험산출내역");
	
	layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	layoutContainer_2.setBorders(false);
	
	LayoutContainer layoutContainer_4 = new LayoutContainer();
	layoutContainer_4.setStyleAttribute("paddingRight", "10px");
	frmlytSch = new FormLayout();
	frmlytSch.setLabelWidth(100);
	frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_4.setLayout(frmlytSch);
	
	Button btnXlsInsr4500Upload = new Button("파일업로드");
	btnXlsInsr4500Upload.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			xlsImportData();
		}
	});
	layoutContainer_4.add(btnXlsInsr4500Upload, new FormData("100%"));
	layoutContainer_4.setBorders(false);
	layoutContainer_1.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	
	LayoutContainer layoutContainer_5 = new LayoutContainer();
	layoutContainer_5.setStyleAttribute("paddingRight", "10px");
	frmlytSch = new FormLayout();
	frmlytSch.setLabelWidth(100);
	frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_5.setLayout(frmlytSch);
	
	Button btnTxtInsr4500Upload = new Button("텍스트업로드");
	btnTxtInsr4500Upload.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			Window.alert("현재 텍스트 업로드는 지원하지 않습니다.");
		}
	});
	layoutContainer_5.add(btnTxtInsr4500Upload, new FormData("100%"));
	layoutContainer_5.setBorders(false);
	layoutContainer_1.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	
	LayoutContainer layoutContainer_3 = new LayoutContainer();
	layoutContainer_3.setStyleAttribute("paddingRight", "10px");
    frmlytSch = new FormLayout();
    frmlytSch.setLabelWidth(100);
    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	layoutContainer_3.setLayout(frmlytSch);
	
	Button btnInsr4500down = new Button("양식다운");
	btnInsr4500down.addListener(Events.Select, new Listener<ButtonEvent>() {
		public void handleEvent(ButtonEvent e) {
			xlsExportData();
		}
	});
	layoutContainer_3.add(btnInsr4500down, new FormData("100%"));
	layoutContainer_1.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
	
	layoutContainer.add(layoutContainer_1);
	layoutContainer_1.setBorders(false);
	fldstNewFieldset.add(layoutContainer);
	layoutContainer.setBorders(false);
	
	plFrmInsr4500.add(fldstNewFieldset);
}

public void reload() {
	// TODO Auto-generated method stub
	if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"))) {
		if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			return;
		}
	}
	
	IColumnFilter filters = null;
	insr3100GridPanel.getTableDef().setTableColumnFilters(filters);
	insr3100GridPanel.getTableDef().addColumnFilter(  "nofctYrMnthNum"
													,   MSFSharedUtils.getSelectedComboValue(srhPayYr,	  "year")
													  + MSFSharedUtils.getSelectedComboValue(srhPayMonth, "month")
													, SimpleColumnFilter.OPERATOR_EQUALS
												   );
	insr3100GridPanel.getTableDef().addColumnFilter(  "payrMangDeptCd"
													, MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd")
													, SimpleColumnFilter.OPERATOR_EQUALS
												   );
	insr3100GridPanel.getTableDef().addColumnFilter(  "emymtDivCd"
													, MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd")
													, SimpleColumnFilter.OPERATOR_EQUALS
												   );
	insr3100GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd");
	insr3100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	
	//20180305추가 
	insr3100GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
	String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd");
	insr3100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS);
	
	String strDtilOccuClsDivCd = InsrUtils.getStrValToBMMultiCombo(  lsDtilOccuClsDivCd
																  , srhDtilOccuClsDivCd.getValue()
																  , "dtilOccuClsNm"
																  , "dtilOccuClsDivCd"
																 );
	insr3100GridPanel.getTableDef().addColumnFilter("dtilOccuClsDivCd", strDtilOccuClsDivCd, SimpleColumnFilter.OPERATOR_EQUALS);
	
	insr3100GridPanel.getTableDef().addColumnFilter(  "businCd"
													, MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd")
													, SimpleColumnFilter.OPERATOR_EQUALS
												   );
	insr3100GridPanel.getTableDef().addColumnFilter("systemkey"
													, MSFSharedUtils.allowNulls(srhSystemkey.getValue())
													, SimpleColumnFilter.OPERATOR_EQUALS
												   );
	insr3100GridPanel.getTableDef().addColumnFilter("nm", MSFSharedUtils.allowNulls(srhNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
	insr3100GridPanel.getTableDef().addColumnFilter(  "resnRegnNum"
													, MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())
													, SimpleColumnFilter.OPERATOR_EQUALS
												   );
	
	String strHdofcDivCd = MSFSharedUtils.allowNulls(srhHdofcDivCd.getValue());
	if(MSFSharedUtils.paramNotNull(srhHdofcDivCd.getValue())) {
		String[] ray = strHdofcDivCd.substring(0, strHdofcDivCd.length()).split(",");
		String chkkey = "";
		for (int i = 0; i < ray.length; i++) {
			BaseModel bmData = lsHdofcDivCd.findModel("commCdNm", ray[i]);
			chkkey += bmData.get("commCd") + ",";
		}
		strHdofcDivCd = chkkey.substring(0, chkkey.length() - 1);
	}
	insr3100GridPanel.getTableDef().addColumnFilter("hdofcDivCd", strHdofcDivCd, SimpleColumnFilter.OPERATOR_EQUALS);
	
	insr3100GridPanel.reload();
}

/* 당월 급여 반영 */
private void payRflctn() {
	Iterator<BaseModel> itBm = insr3100GridPanel.getMsfGrid().getGrid().getStore().getModels().iterator();
	
	if(MSFSharedUtils.paramNotNull(itBm)) {
		List<Insr3100DTO> listInsr3100dto = new ArrayList<Insr3100DTO>();
		List<Record>  lsRec  = new ArrayList<Record>();
		
		while(itBm.hasNext()) {
			Record rec  = new Record(itBm.next());
			lsRec.add(rec);
		}
		
		Iterator<Record> iterRecords = lsRec.iterator();
		
		while(iterRecords.hasNext()) {
//		while(records.hasNext()) {
			
			actionDatabase = ActionDatabase.UPDATE;
//			Record record = (Record)records.next();
			Record record = (Record)iterRecords.next();
			BaseModel bmMapModel = (BaseModel)record.getModel();
			
			Insr3100DTO insr3100dto = new Insr3100DTO();
			
			insr3100dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get(				"dpobCd")));				/** 사업장코드				: dpobCd				*/
			insr3100dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get(			"systemkey")));				/** SYSTEMKEY				: systemkey				*/
			insr3100dto.setNofctYrMnthNum(MSFSharedUtils.allowNulls(bmMapModel.get(		"nofctYrMnthNum")));		/** 정산년월					: nofctYrMnthNum		*/
			insr3100dto.setDspty(MSFSharedUtils.allowNulls(bmMapModel.get(				"dspty")));					/** 차수						: dspty					*/
			insr3100dto.setCertNumHuhd(MSFSharedUtils.allowNulls(bmMapModel.get(		"certNumHuhd")));			/** 증번호					: certNumHuhd			*/
			insr3100dto.setYrlyPayTotAmnt((Long)bmMapModel.get(							"yrlyPayTotAmnt"));			/** 연간보수총액				: yrlyPayTotAmnt		*/
			insr3100dto.setPayMnthAmnt((Long)bmMapModel.get(							"payMnthAmnt"));			/** 보수월액					: payMnthAmnt			*/
			insr3100dto.setYrtxCalcBkdnGrde(MSFSharedUtils.allowNulls(bmMapModel.get(	"yrtxCalcBkdnGrde")));		/** 연말정산등급				: yrtxCalcBkdnGrde		*/
			insr3100dto.setHlthInsrYrtxPrcsYn(MSFSharedUtils.allowNulls(bmMapModel.get(	"hlthInsrYrtxPrcsYn")));	/** 건강보험연말정산처리여부	: hlthInsrYrtxPrcsYn	*/
			insr3100dto.setHlthYrtxApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("hlthYrtxApptnYrMnth")));	/** 건강연말정산적용년월		: hlthYrtxApptnYrMnth	*/
			insr3100dto.setHlthYrtxPrcsDt(MSFSharedUtils.allowNulls(bmMapModel.get(		"hlthYrtxPrcsDt")));		/** 건강연말정산처리일자		: hlthYrtxPrcsDt		*/
			
			listInsr3100dto.add(insr3100dto);
		}
		
		if(listInsr3100dto.size() <= 0) {
			MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
			return;
		}
		
		insr4500Service.activityOnInsr3100(listInsr3100dto, actionDatabase, new AsyncCallback<Long>() {
			public void onFailure(Throwable caught) {
				MessageBox.alert(  MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
								 , MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsr3100(" + actionDatabase.name() + ") : " + caught)
								 , null
								);
			}
			public void onSuccess(Long result) {
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
					reload();
					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});
	} else {
		MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() + "처리할 데이타가 존재하지 않습니다.", null);
		return;
	}
}
	
/* 폼초기화 검색조건포함 */
private void formInit() {
	insr3100GridPanel.getMsfGrid().clearData();
}

public void setRecord(BaseModel record) {
	this.record = record;
}

public void setListRecord(Iterator<Record> records) {
	this.records = records;
}

private Insr4500 getThis() {
	return this;
}

private void fnPopupPsnl0100() {
	//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
	//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
	//검색.처리하면됨.
	MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhNm.getValue()); //인사
//	MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form(); //우편번호
	
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

/* 엑셀 양식 다운 */
private void xlsExportData() {
	HashMap<String, String> param = new HashMap<String, String>();
	
	String year	 = InsrUtils.getSelectedComboValue(srhPayYr,	"year");
	String month = InsrUtils.getSelectedComboValue(srhPayMonth, "month");
	
	param.put("nofctYrMnthNum",  year.concat(month));
	param.put("payrMangDeptCd",  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
	param.put("emymtDivCd",		 MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, 	 "commCd"));
	param.put("deptCd",			 InsrUtils.getStrValToBMMultiCombo(lsDeptCd,	srhDeptCd.getValue(),	 "deptNmRtchnt", "deptCd"));
	param.put("typOccuCd",		 InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm",	 "typOccuCd"));
	param.put("dtilOccuClsDivCd", InsrUtils.getStrValToBMMultiCombo(  lsDtilOccuClsDivCd
																   , srhDtilOccuClsDivCd.getValue()
																   , "dtilOccuClsNm"
																   , "dtilOccuClsDivCd")
			 );
	String strHdofcDivCd = MSFSharedUtils.allowNulls(srhHdofcDivCd.getValue());
	if(MSFSharedUtils.paramNotNull(srhHdofcDivCd.getValue())) {
		String[] ray = strHdofcDivCd.substring(0, strHdofcDivCd.length()).split(",");
		String chkkey = "";
		for(int i = 0; i < ray.length; i++) {
			BaseModel bmData = lsHdofcDivCd.findModel("commCdNm", ray[i]);
			chkkey += bmData.get("commCd") + ",";
		}
		strHdofcDivCd = chkkey.substring(0, chkkey.length() - 1);
	}
	param.put("hdofcDivCd",		 strHdofcDivCd);
	param.put("businCd",		 MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
	param.put("systemkey",		 MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
	param.put("nm",				 MSFSharedUtils.allowNulls(srhNm.getValue()));
	param.put("resnRegnNum",	 MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
	
	if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
		if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
		} else {
			insr3100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr4500Export.do", "extgwtFrame", param);
		}
	} else {
		insr3100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsInsr4500Export.do", "extgwtFrame", param);
	}
}

/* 엑셀 업로드 */
private void xlsImportData() {
	MessageBox.confirm(  "대상자 생성"
					   , "보수총액 대상자를 생성하시겠습니까?<br>(등록되어있는 대상자가 있을시 삭제 처리 됩니다.)"
					   , new Listener<MessageBoxEvent>() {
		@Override
		public void handleEvent(MessageBoxEvent be) {
		//	if("Yes".equals(be.getButtonClicked().getText())) {
			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
				/* only accept certain files */
				String year	 = InsrUtils.getSelectedComboValue(srhPayYr,	"year");
				String month = InsrUtils.getSelectedComboValue(srhPayMonth, "month");
				
				if("".equals(year) || "".equals(month)) {
					MessageBox.info("", "정산년월은 필수 입니다.", null);
				} else {
              		/* get the filename to be uploaded */
					String filename = MSFSharedUtils.allowNulls(insr4500flUp.getValue());
					if(filename.length() == 0) {
						Window.alert("선택된 파일이 없습니다.");
					} else {
						/* submit the form */
						plFrmInsr4500.mask("엑셀 데이타 업데이트 중입니다. 업로드 중...");
						
						/* 파일업로드 처리 */
						plFrmInsr4500.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadInsr4500Import.do");
						System.out.println(GWT.getHostPageBaseURL() + "imp/XlsReadInsr4500Import.do");
						plFrmInsr4500.setEncoding(Encoding.MULTIPART);
						plFrmInsr4500.setMethod(Method.POST);
						plFrmInsr4500.submit();
						plFrmInsr4500.onFrameLoad();
						picBoolFile = true;
					}
					
                    /* reset and unmask the form */
                    /* after file upload */
					plFrmInsr4500.addListener(Events.Submit, new Listener<FormEvent>() {
						public void handleEvent(FormEvent evt) {
							if("success".endsWith(evt.getResultHtml()) && picBoolFile) {
								/* 업로드가  성공했으면 인서트 모듈을 태운다. */
								plFrmInsr4500.unmask();
//								MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null);
								picBoolFile = false;
								evt.setResultHtml("");
							} else {
								if("error".endsWith(evt.getResultHtml()) && picBoolFile) {
									/* 업로드가 성공했으면 인서트 모듈을 태운다. */
									MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
									picBoolFile = false;
									evt.setResultHtml("");
								} else {
									/* 실패 메시지나 에러 메시지 처리. */
									evt.setResultHtml("");
								}
							}
						};
					});
				}
			}
		}
	});
}

	/* 엑셀 다운로드 */
	private void excelFileExport() {
		HashMap<String, String> param = new HashMap<String, String>();
		
		String year	 = InsrUtils.getSelectedComboValue(srhPayYr,	"year");
		String month = InsrUtils.getSelectedComboValue(srhPayMonth, "month");
		String strHdofcDivCd = MSFSharedUtils.allowNulls(srhHdofcDivCd.getValue());
		if(MSFSharedUtils.paramNotNull(srhHdofcDivCd.getValue())) {
			String[] ray = strHdofcDivCd.substring(0, strHdofcDivCd.length()).split(",");
			String chkkey = "";
			for(int i = 0; i < ray.length; i++) {
				BaseModel bmData = lsHdofcDivCd.findModel("commCdNm", ray[i]);
				chkkey += bmData.get("commCd") + ",";
			}
			strHdofcDivCd = chkkey.substring(0, chkkey.length() - 1);
		}
		
		param.put("nofctYrMnthNum",	  year.concat(month));
		param.put("payrMangDeptCd",	  MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("emymtDivCd",		  MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"));
		param.put("deptCd",			  InsrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(), "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",		  InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd, srhTypOccuCd.getValue(), "typOccuNm", "typOccuCd"));
		param.put("dtilOccuClsDivCd", InsrUtils.getStrValToBMMultiCombo(  lsDtilOccuClsDivCd
																		, srhDtilOccuClsDivCd.getValue()
																		, "dtilOccuClsNm"
																		, "dtilOccuClsDivCd"
																	   )
				 );
		param.put("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		param.put("hdofcDivCd",		  strHdofcDivCd);
		param.put("businCd",		  MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
		param.put("systemkey",		  MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
		param.put("nm",				  MSFSharedUtils.allowNulls(srhNm.getValue()));
		param.put("resnRegnNum",	  MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		
		if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			} else {
				insr3100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr4500Export.do", "extgwtFrame", param);
			}
		} else {
			insr3100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr4500Export.do", "extgwtFrame", param);
		}
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