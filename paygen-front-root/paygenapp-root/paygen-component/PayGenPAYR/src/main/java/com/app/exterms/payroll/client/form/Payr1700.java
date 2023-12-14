package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Psnl0130DTO;
import com.app.exterms.payroll.client.form.defs.Psnl0130Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr1700Service;
import com.app.exterms.payroll.client.service.Payr1700ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0100Def;
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
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
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
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr1700  extends MSFPanel { 



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
	   private FormPanel plFrmPayr1700;
	   //private FormData formData; 
	   private String txtForm = "";
	   private XTemplate detailTp; 
	   
	   private EditorGrid<BaseModel> psnl0130GridEdit;
	   private ListStore<BaseModel> psnl0130Store;
		 
	  private PrgmComPsnl0100Def psnl0100Def  = new PrgmComPsnl0100Def("PAYR1700");   // 인사정보 그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel psnl0100GridPanel;
	  
	  
	  private Psnl0130Def psnl0130Def  = new Psnl0130Def("");  									 // 계좌정보 그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel psnl0130GridPanel;
       
      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
  

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
      private ButtonBar topPayr1700Bar;
      private Button btnPayr1700Init; 
      private Button btnPayr1700Sreach;
      private Button btnPayr1700Excel;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */ 
   
     
      private ComboBox<BaseModel> srhPayrMangDeptCd; 			//단위기관
      private ComboBox<BaseModel> srhEmymtDivCd; 				//고용구분 
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; 			//호봉제구분코드  
      
      private MSFMultiComboBox<ModelData> srhDeptCd ;			//부서 
      private ComboBox<BaseModel> srhHdofcCodtnCd; 				//재직상태  
      
      
      private ComboBox<BaseModel> srhDeptGpCd; 					//부서직종그룹코드	   
      private MSFMultiComboBox<ModelData> srhTypOccuCd; 		//직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; 	//직종세
      
      private ComboBox<BaseModel> srhBusinCd;   				//사업
      private TextField<String> srhHanNm;         				//성명
      private TextField<String> srhResnRegnNum;   				//주민번호 
      private HiddenField<String> srhSystemkey;   				//시스템키
      
      private List<ModelData> mDtalistDeptCd ;
      private List<ModelData> mDtalistTypOccuCd ;
      private List<ModelData> mDtalistDtilOccuInttnCd ;
      private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정


  	  private Boolean emptyCheck = false ; 
      private boolean mutilCombo = false;
      
      //--------------- 대상자 업로드 ---------------
      private FileUploadField payr1700flUp;
      private Boolean picBoolFile;
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
		  private void checkPayr1700Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			//2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
				   if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   authExecEnabled() ;
				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
			   }
		  }
			 private void authExecEnabled() { 
				   //------------------
				    //----------------------------------------------------
                 Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
                 
				   gwtAuthorization.formAuthFieldConfig(fldArrField);
				  
				   
                  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                   * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                   * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
                   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                    //String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
                    //GWTAuthorization.formAuthPopConfig(plFrmPayr1700, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
                    //GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
				 //  gwtAuthorization.formAuthConfig(plFrmPayr1700, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
                  /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                   * 권한설정을 위한 콤보처리를 위한 메서드 종료
                   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                //    srhDeptCd.fireEvent(Events.Add);
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
	    private void setPayr1700FormBinding() {
	 	 
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
	private Payr1700ServiceAsync payr1700Service = Payr1700Service.Util.getInstance();	    
	  //공통 코드  
	private ListStore<BaseModel> lsPayrMangDeptCd	= new ListStore<BaseModel>();   //단위기관
	private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();  	//고용구분
	private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	//호봉제구분코드 
	private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	//부서직종그룹코드  		
	private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();  	//직종
	private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>();  	//부서
	private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();  	//사업
	private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	//직종세
	private ListStore<BaseModel> lsHdofcCodtnCd 	= new ListStore<BaseModel>(); 	//재직상태 
	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	
	
	private PrgmComBass0300DTO sysComBass0300Dto; 
	private PrgmComBass0150DTO sysComBass0150Dto;
	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
	private PrgmComBass0350DTO sysComBass0350Dto; //직종세
	private PrgmComBass0320DTO sysComBass0320Dto; //직종
   
	private BaseModel record;
	
	private Iterator<Record> records;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr1700(){
//    	psnl0100GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr1700List(bass0200Dto, new AsyncCallback<List<Payr1700BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr1700(): "+caught), null);
//                msfPayr1700GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr1700BM> result) {
//            	composedPayr1700List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr1700List(List<Payr1700BM> listaMenu) {
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
//        msfPayr1700GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
    private SelectionListener<ButtonEvent> selectionListener = 
	        new SelectionListener<ButtonEvent>() {
	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr1700Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr1700Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnPayr1700Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }

	        }  
	    };
	  
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
            formPayr1700Save();
            break;
        case UPDATE:
            formPayr1700Save();
            break;
        case DELETE:
            formPayr1700Delete();
            break;
        }
    }
     
 
    
    public void formPayr1700Save() {
//  if (isValid()) { 
        List<Psnl0130DTO> listPsnl0130dto = new ArrayList<Psnl0130DTO>();  
        
        while (records.hasNext()) {
      
            Record record = (Record) records.next(); 
            BaseModel bmMapModel = (BaseModel)record.getModel();
              
            Psnl0130DTO psnl0130Dto = new Psnl0130DTO();  
             
            psnl0130Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    		/** column SYSTEMKEY : systemkey */
            psnl0130Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    				/** column 사업장코드 : dpobCd */
            psnl0130Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    		/** column 급여구분코드 : payCd */
            psnl0130Dto.setBnkCd(MSFSharedUtils.allowNulls(bmMapModel.get("bnkCd$commCd")));    		/** column 은행코드 : bnkCd */
            psnl0130Dto.setBnkAccuNum(MSFSharedUtils.allowNulls(record.get("bnkAccuNum")));   		 	/** column 은행계좌번호 : bnkAccuNum */
            psnl0130Dto.setAcntHodrNm(MSFSharedUtils.allowNulls(record.get("acntHodrNm")));    			/** column 예금주명 : acntHodrNm */
            psnl0130Dto.setRpsttvAccuYn((Boolean)record.get("rpsttvAccuYn"));    						/** column 대표계좌여부 : rpsttvAccuYn */
            psnl0130Dto.setAccuNoteCtnt(MSFSharedUtils.allowNulls(record.get("accuNoteCtnt")));    		/** column 계좌비고내용 : accuNoteCtnt */
            
            
            if(psnl0130Dto.getPayCd() == null || "".equals(psnl0130Dto.getPayCd() )) {
            	MessageBox.alert("경고", "급여구분을 선택해주세요.", null);
            	return;
            }else if(psnl0130Dto.getBnkCd() == null || "".equals(psnl0130Dto.getBnkCd() )) {
            	MessageBox.alert("경고", "은행을 선택해주세요.", null);
            	return;
            }else if(psnl0130Dto.getBnkAccuNum() == null || "".equals(psnl0130Dto.getBnkAccuNum()) ) {
            	MessageBox.alert("경고", "계좌번호를 입력주세요.", null);
            	return;
            }else if(psnl0130Dto.getAcntHodrNm() == null || "".equals(psnl0130Dto.getAcntHodrNm()) ) {
            	MessageBox.alert("경고", "예금주를 입력해주세요", null);
            	return;
            }else if(psnl0130Dto.getAcntHodrNm() != null || !"".equals(psnl0130Dto.getAcntHodrNm())) {
            	List<BaseModel> list = psnl0100GridPanel.getGrid().getSelectionModel().getSelectedItems();

            	if(list != null && list.size() > 0){
            		String chkHanNm = "";
            		for(BaseModel bm : list){
            			chkHanNm = bm.get("hanNm");					
            		}
            		
            		if(!chkHanNm.equals(psnl0130Dto.getAcntHodrNm().trim()) ) {	
            			MessageBox.alert("경고", "예금주는 근로자 성명과 일치해야 합니다.", null);
                    	return;
            		}
            	}
            }
            
//            psnl0130Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
//            psnl0130Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
//            psnl0130Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
//            psnl0130Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
//            psnl0130Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
//            psnl0130Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */

            listPsnl0130dto.add(psnl0130Dto);
        }   
        
          
        payr1700Service.activityOnPayr1700Save(listPsnl0130dto,  new AsyncCallback<Long>() {
	        public void onFailure(Throwable caught) {
	            MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                    MSFMainApp.ADMINMESSAGES.ExceptionMessageService("formPayr1700Save(save) : " + caught), null);
	        }
	        public void onSuccess(Long result) { 
	            if (result == 0) {
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                        "저장이 완료되지 않았습니다. 해당 급여구분에 등록된 계좌가 있는지 확인해주세요.", null);
	            } else {
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장이 완료되었습니다.", null);
	                psnl0130GridPanel.reload();
	            } 
	        } 
        });
//  }
  }
     
    private void formPayr1700Delete() {
        //삭제처리 루틴  
//  if (isValid()) { 
        
        if(psnl0130GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
            
            MessageBox.confirm("삭제", "선택하신 계좌정보를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
                @Override
                public void handleEvent(MessageBoxEvent be) {
                   // if("Yes".equals(be.getButtonClicked().getText())){
                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                        
                        payr1700Service.activityOnPayr1700Delete(psnl0130GridPanel.getGrid().getSelectionModel().getSelectedItems() , new AsyncCallback<Long>() {
                            
                            @Override
                            public void onSuccess(Long result) {
                                
                                if (result == 0) {
                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                            "삭제가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                                } else {
                                    MessageBox.alert("삭제완료", "선택하신 계좌정보("+result+")가 삭제되었습니다.", null); 
                                    psnl0130GridPanel.reload();
                                }  
                                
                            }
                            
                            @Override
                            public void onFailure(Throwable caught) {
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("formPayr1700Delete(delete) : " + caught), null);
                                
                            }
                        });
                    }
                }
            });
        } else {
            MessageBox.alert("계좌정보선택", "삭제할 계좌정보를 선택하십시요.", null);
        }
         
//  } 
        
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
//	private void Payr1700Print(String fileName) {
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
//		List<BaseModel> list = psnl0100GridPanel.getGrid().getSelectionModel().getSelectedItems();
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
				
			        detailTp = XTemplate.create(getDetailTemplate());
			    
				   // formData = new FormData("-650");
				    vp = new VerticalPanel();
				    vp.setSpacing(10);
				    createPayr1700Form();  //화면 기본정보를 설정
				    createSearchForm();    //검색필드를 적용
				    createStdGrid();
				    createBottom();		//급여계좌 업로드 필드 적용
				    
				    //엣지변환
				    //vp.setSize("1010px", "700px");
				    vp.setSize("1010px", "750px");
				     
				    /**
				     * Create the relations 
				     */
					  final RelationDef  relPsnl0100 = new RelationDef(psnl0100Def,false);
					  relPsnl0100.addJoinDef("dpobCd", "dpobCd"); 
					  relPsnl0100.addJoinDef("systemkey", "systemkey"); 
					  relPsnl0100.setLinkedObject(psnl0100GridPanel);
					  psnl0130Def.addRelation(relPsnl0100); 
					  
				      // DETAILS 
				      final Grid psnl0100Grid = psnl0100GridPanel.getMsfGrid().getGrid();
				      psnl0100Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
				         public void handleEvent(BaseEvent be) {  
				       	  if (psnl0100GridPanel.getCurrentlySelectedItem() != null) { 
				       		 
				       	    setRecord(psnl0100GridPanel.getCurrentlySelectedItem());
				       	    
				       		psnl0130Def.synchronizeGridDetail(psnl0100GridPanel.getCurrentlySelectedItem(),psnl0130GridPanel ); 
				       		
				       		//psnl0130GridPanel.reload(); 
				       		
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
	  public Payr1700() {
		   
		   //엣지변환
		  //setSize("1010px", "700px");  
			setSize("1010px", "750px");  
	  } 
	
	  public Payr1700(String txtForm) {
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
	
	  private void createPayr1700Form() {
		  
			plFrmPayr1700 = new FormPanel();
			plFrmPayr1700.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr1700());
//			plFrmPayr1700.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 계좌관리");
			plFrmPayr1700.setIcon(MSFMainApp.ICONS.text());
			plFrmPayr1700.setBodyStyleName("pad-text");
			plFrmPayr1700.setPadding(2);
			plFrmPayr1700.setFrame(true);  
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblPayrConst.title_Payr1700(),"PAYR1700");
					}
				});
			plFrmPayr1700.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr1700.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

	           //멀티콤보박스 닫기 
			plFrmPayr1700.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
                @Override
                public void handleEvent(ComponentEvent ce) { 
                
                 //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                        
                //        if (f instanceof MSFMultiComboBox<?>) {
                            
//                          if ("srhDeptCd".equals(f.getName())) {
//                              
//                          } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                              
//                          }
                            
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
                    //    }
                //    } 
                } 
            }); 
		 
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			  
			LayoutContainer layoutContainer_1 = new LayoutContainer(); 
			layoutContainer_1.setLayout(new FlowLayout());
			  
			  ButtonBar buttonBar_1 = new ButtonBar();
			  
//			  Button btnNewButton_2 = new Button("교육사항일괄등록");
//			  btnNewButton_2.setIcon(MSFMainApp.ICONS.accordion());
//			  buttonBar_1.add(btnNewButton_2);
			  layoutContainer_1.add(buttonBar_1);
			  layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			  layoutContainer_1.setBorders(false);
			  
			  LayoutContainer layoutContainer_2 = new LayoutContainer();
			  layoutContainer_2.setLayout(new FlowLayout());
			  
			    
			   topPayr1700Bar = new ButtonBar();    
			   layoutContainer_2.add(topPayr1700Bar);
			   topPayr1700Bar.setAlignment(HorizontalAlignment.RIGHT);
			 
			   	  
			   btnPayr1700Init = new Button("초기화");  
			   btnPayr1700Init.setIcon(MSFMainApp.ICONS.new16());
			   topPayr1700Bar.add(btnPayr1700Init);
			   btnPayr1700Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    		   formInit(); 
			    		}
			    	}); 
		  
		  	
			btnPayr1700Sreach = new Button("조회"); 
			btnPayr1700Sreach.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr1700Bar.add(btnPayr1700Sreach);
		  	btnPayr1700Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    		    reload();  
	    		}
	    	});

		 	
		 	btnPayr1700Excel = new Button("엑셀"); 
		 	btnPayr1700Excel.setIcon(MSFMainApp.ICONS.excel16()); 
		  	topPayr1700Bar.add(btnPayr1700Excel);
		  	btnPayr1700Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			
//	    			psnl0100GridPanel.callExportServlet("");
	    			xlsExportData02();
	    		}
	    	});

		  	
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			layoutContainer_2.setBorders(false);
			plFrmPayr1700.add(layoutContainer);
			layoutContainer.setBorders(false);  
		  	
			//파일업로드 처리
			plFrmPayr1700.setAction("bizform");
			plFrmPayr1700.setEncoding(Encoding.MULTIPART);
			plFrmPayr1700.setMethod(Method.POST);
			
		
			vp.add(plFrmPayr1700);
			//엣지변환
			//plFrmPayr1700.setSize("990px", "680px");
			plFrmPayr1700.setSize("990px", "730px");
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
	 
	 srhSystemkey = new  HiddenField<String>();   //시스템키
	  
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
		
     //재직상태  
     sysComBass0300Dto.setRpsttvCd("A003"); 
     lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto); 
     
     
     // 호봉
 	 sysComBass0300Dto.setRpsttvCd("A048");
 	 lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
     //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		
	   /**
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      * 직종 콤보박스 처리  시작
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	      */
 
	     	    
		     lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
			   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		          public void handleEvent(StoreEvent<BaseModel> be) {  
		           
		            mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		            srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		             
		          }
		      });  
			   
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
                      mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
                      srhDeptCd.getInitStore().add(mDtalistDeptCd);
                      
                  }
              });     
              //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
 		 lsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
        
	    plFrmPayr1700.setLayout(new FlowLayout());
	    
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
	    
	     
	    LayoutContainer layoutContainer = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
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
	    srhPayrMangDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {   

            	  EventType type = be.getType();
		    	   if (type == Store.Add) { 
               		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	checkPayr1700Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
	    
	    LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
	    
	    
	    LayoutContainer layoutContainer_1_1 = new LayoutContainer();
	    
	    
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(60); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1_1.setLayout(frmlytSch); 
	    
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
		                	checkPayr1700Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	    layoutContainer_1.setBorders(false);
	    layoutContainer_1.add(layoutContainer_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	    
	    
	    
	    LayoutContainer layoutContainer_1_2 = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setDefaultWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_1_2.setLayout(frmlytSch);
	    
	    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
	    srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
	    srhRepbtyBusinDivCd.setForceSelection(true);
	    srhRepbtyBusinDivCd.setAllowBlank(true);
	    srhRepbtyBusinDivCd.setMinChars(1);
	    srhRepbtyBusinDivCd.setHideLabel(true);
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
	    
	    layoutContainer_1_2.add(srhRepbtyBusinDivCd, new FormData("100%"));
	    layoutContainer_1_2.setBorders(false);
	    layoutContainer_1.add(layoutContainer_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	    
	    
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
	     
	      LayoutContainer lcSchLeft = new LayoutContainer();
	     //  lcSchLeft.setStyleAttribute("paddingRight", "10px");
	        frmlytSch = new FormLayout();  
	       frmlytSch.setLabelWidth(60); 
	       frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	       lcSchLeft.setLayout(frmlytSch); 
	       
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
			                	checkPayr1700Auth("srhDeptCd", lsDeptCd); 
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
	       
	            
		     
	    lcSchLeft.add(srhDeptCd, new FormData("100%")); 
	       

	    
	    fieldSet.add(lcSchCol, new FormData("100%"));
	    
	    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
	    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
	    lcSchCol.add(lcSch2_1 ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
	    
	    LayoutContainer layoutContainer_3 = new LayoutContainer();
	    layoutContainer_3.setLayout(new ColumnLayout());
	    
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
	    
	       
	    LayoutContainer layoutContainer_2 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setDefaultWidth(0);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_2.setLayout(frmlytSch);
	   
	    
	    srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	    srhTypOccuCd.setName("srhTypOccuCd"); 
	    srhTypOccuCd.setEmptyText("--직종선택--"); 
	    srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	    srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	    srhTypOccuCd.setHideLabel(true);
//	    srhTypOccuCd.setLabelSeparator("");
	    srhTypOccuCd.setWidth(100);
//	    srhTypOccuCd.setFieldLabel("직종");
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
		      }
	            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
		                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
		                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                	//checkPayr1700Auth("srhTypOccuCd", lsTypOccuCd); 
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
	   
	    layoutContainer_2.add(srhTypOccuCd, new FormData("100%")); 
	    
	    LayoutContainer lcSchRight = new LayoutContainer();
      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
        frmlytSch = new FormLayout();  
//        frmlytSch.setLabelWidth(0);
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
        lcTypOccuCd.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));
	    
	    layoutContainer_2.setBorders(false);
	    
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
//                super.componentKeyUp(event);
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
//              @Override
//              public void handleEvent(BaseEvent be) {  
//                  if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//                      srhSystemkey.setValue("");
//                      srhResnRegnNum.setValue("");
//                  }
//               
//              } 
//        }); 
	    
	    
	    layoutContainer_6.add(srhHanNm, new FormData("100%")); 
	    layoutContainer_6.setBorders(false);
	    
	    Button btnHanNm = new Button("검색"); 
	    btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
  	    	public void handleEvent(ButtonEvent e) {
  	    		
  	    	   srhSystemkey.setValue("");
               srhResnRegnNum.setValue("");
  	    		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
  	    		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
  	    		//검색.처리하면됨.
//  	    	    MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue());  //인사  
//  	    		
//  	    		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
//  	    		
//  	    		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
//		            public void handleEvent(BaseEvent be) {
//		            	if (!"".equals(popBindingCom0100.getModel().get("hanNm"))) { 
//		            		srhSystemkey.setValue(MSFSharedUtils.allowNulls(popBindingCom0100.getModel().get("systemkey")));   //시스템키
//		            		srhHanNm.setValue(MSFSharedUtils.allowNulls(popBindingCom0100.getModel().get("hanNm")));
//		            		srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(popBindingCom0100.getModel().get("resnRegnNum")));   //주민번호 
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
	    frmlytSch.setLabelWidth(1); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_7.setLayout(frmlytSch);
	    
	    //주민번호 
	    srhResnRegnNum = new TextField<String>();
	   // srhResnRegnNum.setFieldLabel("주민번호");
	    srhResnRegnNum.setHideLabel(true);
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
	    layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	    
	    layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
	    layoutContainer_5.add(btnHanNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
	    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
	    
	    layoutContainer_7.setBorders(false);
	    layoutContainer_5.setBorders(false);
	     
	    layoutContainer_3.add(lcTypOccuCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
        layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	  
	
	    
	    fieldSet.add(layoutContainer_3);
	    layoutContainer_3.setBorders(false);
	    
	    
	    LayoutContainer layoutContainer_3_1 = new LayoutContainer();
	    layoutContainer_3_1.setLayout(new ColumnLayout());
	    
	    
	    LayoutContainer layoutContainer_11 = new LayoutContainer(); 
        frmlytSch = new FormLayout();  
        frmlytSch.setLabelWidth(60); 
        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
        layoutContainer_11.setLayout(frmlytSch);
        
        srhHdofcCodtnCd = new ComboBox<BaseModel>();
        srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
        srhHdofcCodtnCd.setForceSelection(true);
        srhHdofcCodtnCd.setMinChars(1);
        srhHdofcCodtnCd.setDisplayField("commCdNm");
        srhHdofcCodtnCd.setValueField("commCd");
        srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
        srhHdofcCodtnCd.setEmptyText("--재직선택--");
        srhHdofcCodtnCd.setSelectOnFocus(true); 
       // srhHdofcCodtnCd.setReadOnly(true);
       // srhHdofcCodtnCd.setEnabled(true); 
        srhHdofcCodtnCd.setStore(lsHdofcCodtnCd);  
        srhHdofcCodtnCd.setFieldLabel("재직상태");
        lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
                 srhHdofcCodtnCd.setValue(lsHdofcCodtnCd.getAt(0));
            }
        });    
        layoutContainer_11.add(srhHdofcCodtnCd, new FormData("100%"));
        layoutContainer_11.setBorders(false);  
	    
        
       
        layoutContainer_3_1.setBorders(false); 
	    layoutContainer_3_1.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
       // layoutContainer_3.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   // layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	  
	    fieldSet.add(layoutContainer_3_1);
		
	    plFrmPayr1700.add(fieldSet); 
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
 
 private void createStdGrid() {   
	     
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("계좌정보");
	    
	    LayoutContainer lyrFieldSet = new LayoutContainer(new ColumnLayout());  
	    
	    lyrFieldSet.add(createLeftGrid(),new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4) );
	    lyrFieldSet.add(createRightGrid(),new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6) );
	    
	    fieldSet.add(lyrFieldSet);   
	      
	    plFrmPayr1700.add(fieldSet);
	     
	  } 
 
 private LayoutContainer createLeftGrid() {   
	  
	    LayoutContainer lyrFieldSet = new LayoutContainer(new FitLayout());
	    FormLayout frmlytStd = new FormLayout();  
	    lyrFieldSet.setLayout(frmlytStd);   
		  
	    ContentPanel cp01 = new ContentPanel();   
	    cp01.setHeaderVisible(false);
	    cp01.setFrame(true);   
	    cp01.setIcon(MSFMainApp.ICONS.table());   
	    cp01.setLayout(new FitLayout());   
	    cp01.setSize(370, 440);   
      
	    
	    //msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
	    psnl0100GridPanel = new MSFGridPanel(psnl0100Def, false, false, false, false);
	    psnl0100GridPanel.setHeaderVisible(false);  
	    psnl0100GridPanel.setBodyBorder(true);
	    psnl0100GridPanel.setBorders(true); 
     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
    
	    cp01.add(psnl0100GridPanel); 

	    lyrFieldSet.add(cp01); 
	     
	   return lyrFieldSet;
	     
}   
 
 private LayoutContainer createRightGrid() {   
	  
	    LayoutContainer lyrFieldSet = new LayoutContainer(new FitLayout());
	    FormLayout frmlytStd = new FormLayout();  
	    lyrFieldSet.setLayout(frmlytStd);  
	    
	    ContentPanel cp01 = new ContentPanel();   
	    cp01.setHeaderVisible(false);
	    cp01.setFrame(true);   
	    cp01.setIcon(MSFMainApp.ICONS.table());   
	    cp01.setLayout(new FitLayout());   
	    cp01.setSize(570, 440);   

 
	    //msfCustomForm.setHeaderVisible(false);
	     //Instantiate the GridPanel
	    
	      psnl0130GridPanel = new MSFGridPanel(psnl0130Def, false, false, false, false,false);
	      psnl0130GridPanel.setHeaderVisible(false);  
	      psnl0130GridPanel.setBodyBorder(true);
	      psnl0130GridPanel.setBorders(true);
	      psnl0100GridPanel.setWidth(550);
	      
	    //  psnl0130GridPanel.getMsfGrid().getGrid().setAutoExpandColumn("systemkey");
	  //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다. 
	     // psnl0130Store = new ListStore<BaseModel>();   
	     // psnl0130Store = psnl0130GridPanel.getMsfGrid().getGrid().getStore();
    
          
//	      psnl0130GridEdit = new EditorGrid<BaseModel>(psnl0130GridPanel.getMsfGrid().getGrid().getStore(), psnl0130GridPanel.getMsfGrid().getGrid().getColumnModel());
//	      psnl0130GridEdit.setStripeRows(true);  	      
//	      psnl0130GridEdit.setBorders(true);   
//	     
//	      psnl0130GridEdit.addListener(Events.BeforeEdit, new Listener<BaseEvent>() {
//              public void handleEvent(BaseEvent be) {
//                  Registry.register("currentSelectedRecord", psnl0130GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItem());
//              }
//          });
//	      psnl0130GridEdit.addListener(Events.AfterEdit, new Listener<BaseEvent>() {
//              public void handleEvent(BaseEvent be) {
//                  
//                  psnl0130GridPanel.getTableDef().refreshObjectLinked(psnl0130GridPanel.getCurrentlySelectedItem());
//               // psnl0130GridPanel.getMsfGrid().setCurrentlySelectedItem(psnl0130GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItem());
//                  GWT.log(psnl0130GridPanel.getMsfGrid().getGrid().getSelectionModel().toString());
//                  psnl0130GridEdit.repaint();
//                //psnl0130GridPanel.getMsfGrid().getGrid().getStore().commitChanges();
//                 // psnl0130Store.commitChanges();
//              
////                  AppEvent appEvent = new AppEvent(
////                          MSFEvents.ActivityOnGenericObjects, 
////                          ServiceParameters.getCrtUpdDelParameters(
////                                  tableDef.getTable(), 
////                                  msfGrid.getCurrentlySelectedItem(),
////                                  tableDef.getTableAttributes(),
////                                  ActionDatabase.UPDATE, 
////                                  tableDef.getCustomSaveMethod(),
////                                  tableDef.isReloadData()));
////                  appEvent.setSource(MSFGridPanel.this);
////                  Dispatcher.forwardEvent(appEvent);
//              }
//          });
//	      psnl0130GridEdit.addListener(Events.CancelEdit, new Listener<BaseEvent>() {
//              public void handleEvent(BaseEvent be) {
//                  //psnl0130GridPanel.getMsfGrid().getGrid().getStore().rejectChanges();
//                  psnl0130GridPanel.getMsfGrid().getGrid().getStore().rejectChanges();
//              }
//          });
//	      
//	      psnl0130GridEdit.getSelectionModel().addListener(Events.SelectionChange, 
//	                new Listener<SelectionChangedEvent<BaseModel>>() {  
//	            public void handleEvent(SelectionChangedEvent<BaseModel> be) {
//	                psnl0130GridPanel.getTableDef().refreshObjectLinked(psnl0130GridPanel.getCurrentlySelectedItem());
//	            }
//	        });
           
	       //
	      cp01.add(psnl0130GridPanel); 
	     
	      cp01.addButton(new Button("신규", MSFMainApp.ICONS.addSmall(), new SelectionListener<ButtonEvent>() {   
	    	  @Override  
	    	  public void componentSelected(ButtonEvent ce) {   
	    		  formNewRows();
	    	  }   
	      }));  
		  	   
		    cp01.addButton(new Button("저장", MSFMainApp.ICONS.saveSmall(), new SelectionListener<ButtonEvent>() {   
		      @Override  
		      public void componentSelected(ButtonEvent ce) {  
 
		          if (psnl0130GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
		              
		              MessageBox.alert("공제", "저장할 계좌 데이타가 존재하지 않습니다.", null);
		              return;
		          }
		          
		          
		          //--
			       Iterator<BaseModel> itBm = psnl0130GridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator(); 
			       
			       List<Record>  lsRec  = new ArrayList<Record>();
			          
			       while (itBm.hasNext()) {
		
			    	   Record rec = new Record(itBm.next());
			    	   lsRec.add(rec);
			       }
			       
			       setListRecord(lsRec.iterator());
			       
			       Iterator<Record> iter = getListRecord();
			           
		           List <String> list = new ArrayList<String>();

		           while (iter.hasNext()) {
		        	   
		        	   Record recData = (Record) iter.next(); 
		        	   BaseModel bmMapModel = (BaseModel)recData.getModel();
		               
		        	   Psnl0130DTO psnl0130Dto = new Psnl0130DTO();  
		 	        
		        	   psnl0130Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    			/** column SYSTEMKEY : systemkey */
		        	   psnl0130Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    				/** column 사업장코드 : dpobCd */
		        	   psnl0130Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    		/** column 급여구분코드 : payCd */
		        	   psnl0130Dto.setBnkCd(MSFSharedUtils.allowNulls(bmMapModel.get("bnkCd$commCd")));    		/** column 은행코드 : bnkCd */
		        	   
			           list.add(psnl0130Dto.getPayCd());
		           }
		          //--
		          
                  Iterator<Record> iterRecords = psnl0130GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
                  
		           while (iterRecords.hasNext()) {
		        	   
		        	   int iCnt = 0;
		       
		        	   Record recData = (Record) iterRecords.next(); 
		        	   BaseModel bmMapModel = (BaseModel)recData.getModel();
		               
		        	   Psnl0130DTO psnl0130Dto = new Psnl0130DTO();  
		 	        
		        	   psnl0130Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    			/** column SYSTEMKEY : systemkey */
		        	   psnl0130Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    				/** column 사업장코드 : dpobCd */
		        	   psnl0130Dto.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    		/** column 급여구분코드 : payCd */
		        	   psnl0130Dto.setBnkCd(MSFSharedUtils.allowNulls(bmMapModel.get("bnkCd$commCd")));    		/** column 은행코드 : bnkCd */
		        	   
		        	   for(int i = 0; i < list.size(); i++) {
		        		   if(psnl0130Dto.getPayCd() ==  list.get(i) || psnl0130Dto.getPayCd().equals(list.get(i)) ) {
		        			   iCnt = iCnt + 1;
		        		   }
		        	   }
		        	   
		        	   if(iCnt >= 2  ) {
		        		   MessageBox.alert("오류", "해당 급여구분에 이미 등록된 계좌가 존재합니다. 데이터를 확인해주세요.", null);
	            			return;
		        	   }
		        	   
		           }
		           
		           iterRecords = psnl0130GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
		           setListRecord(iterRecords);
		          
                  doAction(ActionDatabase.INSERT);
 	              //formPayr1700Save();
		      }   
		    }));   
		    cp01.addButton(new Button("삭제",  MSFMainApp.ICONS.deleteSmall(), new SelectionListener<ButtonEvent>() {   
			      @Override  
			      public void componentSelected(ButtonEvent ce) {   
			          doAction(ActionDatabase.DELETE);
			         // formPayr1700Delete();
			      }
			 }));
		  
	    lyrFieldSet.add(cp01); 
	    
	    return lyrFieldSet;
	     

}

 private void createBottom() {
	 
		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setHeadingHtml("양식 업로드");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout(1));
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
//		layoutContainer_1.setLayout(new HBoxLayout()); 
		layoutContainer_1.setLayout(new ColumnLayout()); 
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setStyleAttribute("paddingRight", "10px");
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(100); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2.setLayout(frmlytSch);
		
		payr1700flUp = new FileUploadField();
		payr1700flUp.setName("payr1700flUp");
		payr1700flUp.setValidator(new Validator() {  
	   		@Override  
	   		public String validate(Field<?> field, String value) { 
	   			value = value.toLowerCase();        
	   			String result = "xls 파일이 아닙니다., 다시선택하십시요.";
	   			if(value.endsWith(".xls") || value.endsWith(".xlsx")) {
	   				result = null;        
	   			}        
	   			return result;  
	   		} 
	   	});
		layoutContainer_2.add(payr1700flUp, new FormData("100%"));
		payr1700flUp.setFieldLabel("양식선택");
		
//		HBoxLayoutData hbld_layoutContainer_2 = new HBoxLayoutData();
//		hbld_layoutContainer_2.setFlex(1.0);
//		layoutContainer_1.add(layoutContainer_2, hbld_layoutContainer_2);
		layoutContainer_1.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		layoutContainer_2.setBorders(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();
	    frmlytSch.setLabelWidth(100); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSch);
		
		Button btnXlsPayr1700Upload = new Button("양식업로드");
		btnXlsPayr1700Upload.addListener(Events.Select, new Listener<ButtonEvent>() {
	 		public void handleEvent(ButtonEvent e) {
	 			xlsImportData();	//계좌 업로드
	 		}
		});
		layoutContainer_4.add(btnXlsPayr1700Upload, new FormData("100%"));
		layoutContainer_4.setBorders(false);
		layoutContainer_1.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch);
		
		Button btnPayr1700down = new Button("양식다운");
		btnPayr1700down.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				xlsExportData();
			}
		});
		
		layoutContainer_3.add(btnPayr1700down, new FormData("100%"));
		layoutContainer_1.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
		
		layoutContainer.add(layoutContainer_1);
		layoutContainer_1.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		 
		plFrmPayr1700.add(fldstNewFieldset);
	}
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reload() {
			// TODO Auto-generated method stub 
		   //readPayr1700();
			IColumnFilter filters = null;
			psnl0100GridPanel.getTableDef().setTableColumnFilters(filters);
			
			/*  private ComboBox<BaseModel> srhTypOccuCd;    //직종  
		      private ComboBox<BaseModel> srhEmymtDivCd;     //고용구분 
		      private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관 
		      private ComboBox<BaseModel> srhDeptCd ;        //부서 
		      private ComboBox<BaseModel> srhBusinCd;        //사업
		      private TextField<String> srhHanNm;            //성명
		      private TextField<String> srhResnRegnNum;      //주민번호 
		      private HiddenField<String> srhSystemkey;      //시스템키 */
			
			
		 	psnl0100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			psnl0100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
			
			 String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
             psnl0100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
			//psnl0100GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
           //20180305추가 
             psnl0100GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             psnl0100GridPanel.getTableDef().addColumnFilter("repbtyBusinDivCd", MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
             
             String strTypOccuCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
             psnl0100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
            // psnl0100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
           //  String strPyspGrdeCd = PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
           //  psnl0100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
           //  psnl0100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
             String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
             psnl0100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
           //  psnl0100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
		
            psnl0100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	        psnl0100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(srhHdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
	        
			psnl0100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			   
			psnl0100GridPanel.reload();
		}
	
	 //폼초기화 검색조건포함 
	   private void formInit() {
          BaseModel bmInit = new BaseModel();
      
		   setRecord(bmInit);
		   
//		   srhTypOccuCd.setValue(bmInit); //직종  
//		   srhDtilOccuInttnCd.setValue(bmInit);
//		   srhEmymtDivCd.setValue(bmInit); //고용구분 
//		   srhPayrMangDeptCd.setValue(bmInit); //단위기관
//
//		   srhDeptCd.setValue("");   //부서 
//		   srhDeptNm.setValue("");
//		   srhBusinCd.setValue(bmInit);    //사업
		   srhHanNm.setValue("");         //성명
		   srhResnRegnNum.setValue("");   //주민번호 
		   srhSystemkey.setValue("");   //시스템키
		   
		   //grid init
		   psnl0130GridPanel.getMsfGrid().clearData();
		   psnl0100GridPanel.getMsfGrid().clearData();

	   }
	   
	   /**
	    * 신규로우를 생성한다.
	    */
	   public void formNewRows() {
	        
	       if (MSFSharedUtils.paramNull(record) || MSFSharedUtils.paramNull(record.get("systemkey"))) {
	           MessageBox.alert("등록", "대상자를 선택하신 후 등록 하십시요!", null);
	           return;
	       }
	       
	       BaseModel bmData = psnl0130GridPanel.getTableDef().getDefaultValues(); 
	       
        	   
    	       bmData.set("dpobCd",(String)record.get("dpobCd"));					/** column 사업장코드 : dpobCd */
    	       bmData.set("systemkey",(String)record.get("systemkey")); 	 		/** column SYSTEMKEY : systemkey */ 
    	       bmData.set("payCd$commCd","B0150000");  							/** column SYSTEMKEY : systemkey */ 
    	       bmData.set("payCd$commCdNm","월급여");  							/** column SYSTEMKEY : systemkey */ 
    	       
    	       
    	       psnl0130GridPanel.getMsfGrid().getGrid().stopEditing();   	
               psnl0130GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
               psnl0130GridPanel.getMsfGrid().getGrid().startEditing(psnl0130GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
//           }
	       // bnkCd$commCd=B0010011, =, acntHodrNm=장익재,   bnkCd$commCdNm=농협은행

	   }
	  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 
	   
	   public void setListRecord(Iterator<Record> records) {
	       this.records = records;
	   }
     

	   private Payr1700 getThis(){
	       return this;
	   }
	   
	   
	/* 엑셀다운로드 */
	private void excelFileExport() {
//		MessageBox.confirm("근태 생성", "근태생성을 하시겠습니까?<br>(등록되어있는 근태가 있을시 삭제 처리 됩니다.)",new Listener<MessageBoxEvent>() {
//			@Override
//			public void handleEvent(MessageBoxEvent be) {
//				if("Yes".equals(be.getButtonClicked().getText())) {
					HashMap<String, String> param = new HashMap<String, String>();
					
					param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,	"payrMangDeptCd"));
					param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,	"mangeDeptCd"));
					param.put("emymtDivCd",		MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,		"commCd"));
					param.put("deptCd",			 PayrUtils.getStrValToBMMultiCombo(lsDeptCd,		  srhDeptCd.getValue(),			 "deptNmRtchnt",  "deptCd"));
					param.put("typOccuCd",		 PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,		  srhTypOccuCd.getValue(),		 "typOccuNm",	  "typOccuCd"));
	//				param.put("pyspGrdeCd",		 PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,		  srhTypOccuCd.getValue(),		 "typOccuNm",	  "pyspGrdeCd"));
					param.put("dtilOccuInttnCd", PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm", "dtilOccuInttnCd"));
					param.put("businCd",		MSFSharedUtils.getSelectedComboValue(srhBusinCd,		"businCd"));
					
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
					
					param.put("hdofcCodtnCd",	strHdofcCodtnCd);
					param.put("systemkey",		MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
					param.put("hanNm",			MSFSharedUtils.allowNulls(srhHanNm.getValue()));
					param.put("resnRegnNum",	MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
					
					if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
						if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
						} else {
							psnl0130GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFilePayr1700Export.do", "extgwtFrame", param);
						}
					} else {
						psnl0130GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFilePayr1700Export.do", "extgwtFrame", param);
					}
//				}
//			}
//		});
	}
	
	/* 급여계좌 업로드 */
	private void xlsImportData() {
		MessageBox.confirm("계좌 등록", "급여 계좌를 등록하시겠습니까?<br>(등록되어있는 대상자가 있을시 삭제 처리 됩니다.)", new Listener<MessageBoxEvent>() {
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())) {
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					//HashMap<String, String> param = new HashMap<String, String>();
					//only accept certain files
					//get the filename to be uploaded
					String filename = MSFSharedUtils.allowNulls(payr1700flUp.getValue());
					
					if(filename.length() == 0) {
						Window.alert("선택된 파일이 없습니다.");
					} else {
						//submit the form
						plFrmPayr1700.mask("엑셀 데이타 업데이트 중입니다. 업로드 중...");
						//파일업로드 처리
						
						plFrmPayr1700.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadPayr1700Import.do");
//						System.out.println(GWT.getHostPageBaseURL() + "imp/XlsReadPayr1700Import.do");
						plFrmPayr1700.setEncoding(Encoding.MULTIPART);
						plFrmPayr1700.setMethod(Method.POST);
						plFrmPayr1700.submit();
						plFrmPayr1700.onFrameLoad();
						picBoolFile = true;
					}
					
					//reset and unmask the form
					//after file upload 
					plFrmPayr1700.addListener(Events.Submit, new Listener<FormEvent>() {
						public void handleEvent(FormEvent evt) {
							if("success".endsWith(evt.getResultHtml()) && picBoolFile) {
								//업로드가 성공했으면 인서트 모듈을 태운다.
								plFrmPayr1700.unmask();
//								MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null);
								picBoolFile = false;
								evt.setResultHtml("");
							} else {
								if("error".endsWith(evt.getResultHtml()) && picBoolFile) {
									//업로드가  성공했으면 인서트 모듈을 태운다.
									MessageBox.alert("", "엑셀 업로드가 비정상적으로종료되었습니다.", null);
									picBoolFile = false;
									evt.setResultHtml("");
								} else {
									//실패 메시지나 에러 메시지 처리.
									evt.setResultHtml("");
								} 
							}
						};
					});
				}
			}
		});
	}
	
	public Iterator<Record>  getListRecord() {
		return this.records;
	}
	
	/* 엑셀 양식 저장 */
	private void xlsExportData() {
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("payrMangDeptCd",	MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("mangeDeptCd",	MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd, "mangeDeptCd"));
		param.put("emymtDivCd",			MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,	"commCd"));
		param.put("deptCd",			 	PayrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),  "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",		 	PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,	srhTypOccuCd.getValue(),	"typOccuNm", "typOccuCd"));
		param.put("dtilOccuInttnCd", 	PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm",	"dtilOccuInttnCd"));
		param.put("businCd",				MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
		param.put("hdofcCodtnCd",		MSFSharedUtils.getSelectedComboValue(srhHdofcCodtnCd, "commCd"));
		param.put("systemkey",			MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
		param.put("hanNm",				MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum",		MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		
		if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			} else {
				psnl0130GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr1700Export.do", "extgwtFrame", param);
			}
		} else {
			psnl0130GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr1700Export.do", "extgwtFrame", param);
		}
	}
	
	
	
	/* 엑셀 데이터 저장 */
	private void xlsExportData02() {
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("payrMangDeptCd",	MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
		param.put("mangeDeptCd",	MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd, "mangeDeptCd"));
		param.put("repbtyBusinDivCd",	MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd"));
		param.put("emymtDivCd",			MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,	"commCd"));
		param.put("deptCd",			 	PayrUtils.getStrValToBMMultiCombo(lsDeptCd, srhDeptCd.getValue(),  "deptNmRtchnt", "deptCd"));
		param.put("typOccuCd",		 	PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,	srhTypOccuCd.getValue(),	"typOccuNm", "typOccuCd"));
		param.put("dtilOccuInttnCd", 	PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm",	"dtilOccuInttnCd"));
		param.put("businCd",				MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
		param.put("hdofcCodtnCd",		MSFSharedUtils.getSelectedComboValue(srhHdofcCodtnCd, "commCd"));
		param.put("systemkey",			MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()));
		param.put("hanNm",				MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		param.put("resnRegnNum",		MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));
		
		if(MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd, "commCd"))) {
			if("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "사업명을 선택하십시요.", null);
			} else {
				psnl0130GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr170002Export.do", "extgwtFrame", param);
			}
		} else {
			psnl0130GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr170002Export.do", "extgwtFrame", param);
		}
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

//	    //부서 
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
