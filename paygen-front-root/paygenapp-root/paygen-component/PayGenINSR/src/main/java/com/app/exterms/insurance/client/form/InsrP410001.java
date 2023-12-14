package com.app.exterms.insurance.client.form;
    
  
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.service.InsrP410001Service;
import com.app.exterms.insurance.client.service.InsrP410001ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.payroll.client.dto.InfcPkgPayr0540DTO;
import com.app.exterms.payroll.client.form.defs.InfcPkgPayr0540Def;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFServiceFailureHandler;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class InsrP410001   extends MSFFormPanel {  

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
 
	  private  ContentPanel cpInsr4101;  

	//예외처리-건강보험...
	  private InfcPkgPayr0540Def payr0540LDef  = new InfcPkgPayr0540Def("InsrLP410001");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payrL0540GridPanel;
	  
	//예외처리-건강보험...
	  private InfcPkgPayr0540Def payr0540RDef  = new InfcPkgPayr0540Def("InsrRP410001");   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payrR0540GridPanel;
	  
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
    
  private MSFPanel caller;
  private Boolean reading = false;
  public  FormBinding formBinding;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ButtonBar topInsrP410001Bar;
  private Button btnInsrP410001Init;
  private Button btnInsrP410001New;
  private Button btnInsrP410001Save;
  private Button btnInsrP410001Del;
  private Button btnInsrP410001Sreach;
//  private Button btnInsrP410001Print;
  private Button btnInsrP410001Excel;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  
  // 검색 폼 바인딩 처리 함수 
  private ComboBox<BaseModel> srhPayrMangDeptCd; //단위기관
  private ComboBox<BaseModel> srhEmymtDivCd; //고용구분 

  
  
  
//  private ComboBox<BaseModel> srhTypOccuCd; //직종  
//  private HiddenField<String> srhPyspGrdeCd; //호봉등급 
//  private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
  
  private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
  private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
  
  private MSFMultiComboBox<ModelData> srhDeptCd ;    //부서 
//  private ComboBox<BaseModel> srhDeptCd ;    //부서 
//  private TextField<String> srhDeptCd; //부서코드
//  private TextField<String> srhDeptNm; //부서명  
//  private Button btnSrhDeptCd;
//  private TextField<String> srhMangeDeptCd; //관리부서 수정
//  private TextField<String> srhMangeDeptNm; //관리부서 수정  
  
  private ComboBox<BaseModel> srhBusinCd;    //사업
  private TextField<String> srhHanNm;         //성명
  private TextField<String> srhResnRegnNum;   //주민번호 
  private HiddenField<String> srhSystemkey;   //시스템키
//  private ComboBox<BaseModel> srhHdofcCodtnCd; //재직상태  
  private MSFMultiComboBox<ModelData> srhHdofcCodtnCd; //재직상태  
   
  private List<ModelData> mDtalistHdofcCodtnCd ;
  private List<ModelData> mDtalistDeptCd ;
  private List<ModelData> mDtalistTypOccuCd ;
  private List<ModelData> mDtalistDtilOccuInttnCd ;
  
  private boolean mutilCombo = false;    
 
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */


      private HiddenField<String> dpobCd;  //사업장코드
      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */ 
//      
//      private HiddenField<String>  pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
//      
//      private HiddenField<String>  payCd ;  /** column 급여구분코드 : payCd */
//
//      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */
//
//      private HiddenField<Long> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
//      
//      private HiddenField<String> emymtDivCd;   /** column 주민등록번호 : resnRegnNum */
//
//      private HiddenField<String> currAffnDeptCd ;  /** column 부서 : deptNm */
//
//      private HiddenField<String> businCd;   /** column 사업코드 : businNm */
//
//      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuNm */ 
//       
//      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
//      
//      
//      private HiddenField<String>  pyspGrdeCd;  /**  column 고용구분 : emymtDivNm */
//      
//      private TextField<String> 	frstEmymtDt  ;                         /**  column 최초고용일자 : frstEmymtDt */
//    
 
      
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
      
	   //화면 폼 바인딩 처리 
	    private void setPayr410001FormBinding() {
	 	 
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
	    private InsrP410001ServiceAsync insrP410001Service = InsrP410001Service.Util.getInstance();    
	 
	    private ListStore<BaseModel>  lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
  		
 		 //--------------------부서 불러 오는 함수 ------------------------------------------------
 	 	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
 		 //--------------------부서 불러 오는 함수 ------------------------------------------------
 		   
 		//--------------------사업 불러 오는 함수 -------------------------------------------------
 		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
 	   //--------------------사업 불러 오는 함수 -------------------------------------------------
 		
 		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
 		private ListStore<BaseModel>  lsHdofcCodtnCd = new ListStore<BaseModel>(); //재직상태 
 		
 		private ListStore<BaseModel>  lsLogSvcYrNumCd   = new ListStore<BaseModel>(); //근속년수코드  
 		private ListStore<BaseModel>  lsLogSvcMnthIcmCd   = new ListStore<BaseModel>(); //근속월수코드   
 		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();//직종세
 		 
 		
 		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
 	 	private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
 		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
 		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
 		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
 		 private PrgmComBass0320DTO sysComBass0320Dto;	//직종
 		 
 		private SysCoCalendarDTO msfCoCalendarDto;   
 		
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
//		private void Payr4100Print(String fileName) {
	// 
//			// 출력물 디렉토리 패스경로 인사 : PSNL
//			String strDirPath = "PAYR";
//			// mrd 출력물
//			String rdaFileName = fileName+".mrd";
//			// 보낼 파라미터
//			
//			
//			//검색조건
//	 	String serarchParam = "";
////			
////			String name = searchName.getValue() == null ? "" : searchName.getValue();
////			String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////			String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////			//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////			String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////			String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////			String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////			
////			serarchParam += "["+name+"]";
////			serarchParam += "["+resn+"]";
////			serarchParam += "["+hdofcCodtnCd+"]";
////			serarchParam += "[]";
////			//serarchParam += "["+manageDeptCd+"]";
////			serarchParam += "["+deptCd+"]";
////			serarchParam += "["+emymtDivCd+"]";
////			serarchParam += "["+typOccuCd+"]";
//			
//			List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
//			String checkedSystemKeys = "";
//			if(list != null && list.size() > 0){
//				String chkkey = "";
//				for(BaseModel bm : list){
//					chkkey += "'"+bm.get("systemkey")+"',";
//				}
//				
//				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				
//			}
//			String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//			
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	//
//		}

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	    public void deleteInsrP410001() {
	   //   if (isValid()) { 
	            
	            if(payrL0540GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
	                MessageBox.confirm("삭제", "선택된 대상자를 삭제하시면 관련된 데이타가 모두 삭제됩니다. \n 데이타를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
	                    @Override
	                    public void handleEvent(MessageBoxEvent be) {
	                       // if("Yes".equals(be.getButtonClicked().getText())){
	                    	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                             
	                             List<BaseModel> listModels = payrL0540GridPanel.getGrid().getSelectionModel().getSelectedItems();
	                             
	                             insrP410001Service.deleteInsrP410001(listModels,actionDatabase , new AsyncCallback<Long>() {
	                                   public void onFailure(Throwable caught) {
	                                   	 MSFServiceFailureHandler handler = new MSFServiceFailureHandler();
	                                        handler.handleServiceFailure(caught);
	                                     //  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                     //         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("payr40500Delete(" + actionDatabase.name() + ") : " + caught), null);
	                                   }
	                                  
	                                   @Override
	                                   public void onSuccess(Long result) {
	                                       if (result == 0) {
	                                           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                                   "삭제가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                                       } else {
	                                           MessageBox.alert("삭제완료", "선택하신 예외건강보험 ("+result+")건이 삭제되었습니다.", null);
	                                           reload();
	                                       } 
	                                       
	                                     
	                                       
	                                   }
	                                 
	                               });   
	                        }
	                    }
	                }); 
	            } else {
	                MessageBox.alert("예외건강보험선택", "삭제할 예외건강보험대상자를 선택하십시요.", null);
	            }
	             
	   //   }
	      }  	
	    
	 /**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/ 
 
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
 
	    @Override
	    protected void onRender(Element parent, int index) {
	      super.onRender(parent, index);
	        
	    }

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
		  private void checkInsrP410001Auth( String authAction, ListStore<BaseModel> bm) {   
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
                 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
                  
                 gwtAuthorization.formAuthFieldConfig(fldArrField);
                 
                 
                 srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
	                srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
			   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
                ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
               //  String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
                // GWTAuthorization.formAuthPopConfig(cpInsr4101, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
               //  GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
			 //  gwtAuthorization.formAuthConfig("srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
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
		  
//	  	  private AuthAction authAction;
//	  	  private int checkCntDef = 4;   //체크 값 갯수 
//	  	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//	  	  /**
//	  	   * 권한설정 처리 체크 
//	  	   * AuthAction 
//	  	   */
//	  	  private void checkInsrP410001Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	      	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//	  		 
//	  		   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//	  		    
//	                
//	              
//	                  
//	                  //----------------------------------------------------
//	                  unmask(); 
//	                  //MSFMainApp.unmaskMainPage();
//	                   
//	  		   }
//	  	  }  
	       
	    /**
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	     **/	
	    
	  public InsrP410001(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
		  
		  //콤보 권한초기화
		   initLoad(); 
		   // this.setFrame(false);
	       // this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		  
	        cpInsr4101 = new ContentPanel();
		    createInsrP410001Form();  //화면 기본정보를 설정 
		  
		    createBottom();
		    createSearchForm();    //검색필드를 적용
		    createStandardForm();    //기본정보필드    
		    
		    /**
	          * Create the relations 
	          */
			   final RelationDef  relRPayr0540 = new RelationDef(payr0540LDef,false);
			   relRPayr0540.addJoinDef("dpobCd", "dpobCd"); 
			   relRPayr0540.addJoinDef("systemkey", "systemkey"); 
			   relRPayr0540.setLinkedObject(payrL0540GridPanel);
			   payr0540RDef.addRelation(relRPayr0540); 
	           
	 
	           // DETAILS 
	           final Grid payr0540LGrid = payrL0540GridPanel.getMsfGrid().getGrid();
	           payr0540LGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	              public void handleEvent(BaseEvent be) {  	            	
	            	  if (payrL0540GridPanel.getCurrentlySelectedItem() != null) { 
	            		  setRecord(payrL0540GridPanel.getCurrentlySelectedItem());	
	            		  payr0540RDef.synchronizeGridDetail(payrL0540GridPanel.getCurrentlySelectedItem(), payrR0540GridPanel ); 
	            		  
	            		  dpobCd.setValue(MSFSharedUtils.allowNulls(record.get("dpobCd")));
		            	   systemkey.setValue(MSFSharedUtils.allowNulls(record.get("systemkey")));
		            	 //  payrR0540GridPanel.reload(); 
		            	   actionDatabaseSetRead();
		            	   
	            	   } 
	           }
	      });  
	           
		   
		   cpInsr4101.setBodyBorder(false);
		   cpInsr4101.setBorders(false);
		   cpInsr4101.setHeaderVisible(false);
		  //cpInsr4101.setSize("810px", "710px");  
		    
		    this.add(cpInsr4101);
		    formBinding = new FormBinding(this, true);
			this.setSize("996px", "640px");  
	  } 
	    
	  private void actionDatabaseSetRead(){
		  actionDatabase = ActionDatabase.READ; 
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
	  private  void createInsrP410001Form() { 
		   
		  dpobCd = new HiddenField<String>();  //사업장코드
		  systemkey = new HiddenField<String>();    /** column SYSTEMKEY : systemkey */
		  
		  //멀티콤보박스 닫기 
		  cpInsr4101.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
           @Override
           public void handleEvent(ComponentEvent ce) { 
           
            //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                   
           //        if (f instanceof MSFMultiComboBox<?>) {
                       
//                       if ("srhDeptCd".equals(f.getName())) {
//                           
//                       } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                           
//                       }
                       
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
		    
	 
		  cpInsr4101.setSize("976px", "640px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		     
		  //  srhPyspGrdeCd = new HiddenField<String>(); 
	         srhSystemkey = new HiddenField<String>();  //시스템키 
	        
	     
		     sysComBass0150Dto = new PrgmComBass0150DTO();
			 sysComBass0300Dto = new PrgmComBass0300DTO();
			 sysComBass0400Dto = new PrgmComBass0400DTO();
			 sysComBass0500Dto = new PrgmComBass0500DTO(); 
			 sysComBass0350Dto = new PrgmComBass0350DTO();
			 sysComBass0320Dto = new PrgmComBass0320DTO();
			 
			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
			 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
			
			 //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
			// sysComBass0400Dto.setDeptDspyYn("Y");
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
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //고용구분
			 sysComBass0300Dto.setRpsttvCd("A002");
			 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			
			 
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			 //재직상태  
			 sysComBass0300Dto.setRpsttvCd("A003");
			 lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
			 lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
	              public void handleEvent(StoreEvent<BaseModel> be) {  
	                  mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
	                  srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
	                  
	              }
	          });   
			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			  

	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         //근무년수
	         sysComBass0300Dto.setRpsttvCd("A007");
	         lsLogSvcYrNumCd   = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         sysComBass0300Dto.setMangeItem02("");

	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         //근무월수  
	         sysComBass0300Dto.setRpsttvCd("A006");
	         sysComBass0300Dto.setMangeItem02("Y");
	         lsLogSvcMnthIcmCd  = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
	         //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	         sysComBass0300Dto.setMangeItem02("");
			 
			 
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
//		     	    typOccuCdGrid.add(typOccuCdGridPanel); 
//		     		cpInsr4101.add(typOccuCdGrid);
		     	    
	         lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
   		    lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
  	            public void handleEvent(StoreEvent<BaseModel> be) {  
  	             
                    mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
                    srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
                     
                  }
              });  
			 
		   cpInsr4101.setLayout(new FlowLayout());
		    
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
		    fieldSet.add(lcSchCol, new FormData("100%"));
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_14.setLayout(frmlytSch);
		    
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
			                	checkInsrP410001Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
	                	 }
			    	   
	            }
	        });    
		    srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	  	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	  	    	    // sysComBass0400Dto.setDeptDspyYn("Y");
	  	          sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
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
		    layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
		    layoutContainer_14.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer(); 
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_1.setLayout(frmlytSch);
	        
	        srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
	        srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
//	        srhHdofcCodtnCd.setForceSelection(true);
//	        srhHdofcCodtnCd.setMinChars(1);
//	        srhHdofcCodtnCd.setDisplayField("commCdNm");
//	        srhHdofcCodtnCd.setValueField("commCd");
	       // srhHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
	        srhHdofcCodtnCd.setEmptyText("--재직선택--");
//	        srhHdofcCodtnCd.setSelectOnFocus(true); 
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

	            	checkInsrP410001Auth("srhHdofcCodtnCd",lsHdofcCodtnCd); 
	            	 
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
	        layoutContainer_1.add(srhHdofcCodtnCd, new FormData("100%"));
	        layoutContainer_1.setBorders(false); 
	        
	        
	        LayoutContainer layoutContainer11 = new LayoutContainer(); 
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer11.setLayout(frmlytSch);
	        
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
			                	checkInsrP410001Auth("srhEmymtDivCd", lsEmymtDivCd); 
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
	        layoutContainer11.add(srhEmymtDivCd, new FormData("100%"));
	        layoutContainer11.setBorders(false);
	        

	        LayoutContainer layoutContainer_5 = new LayoutContainer();
	        layoutContainer_5.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_6 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_6.setLayout(frmlytSch);
	        
	        srhHanNm = new TextField<String>();
	        srhHanNm.setName("srhHanNm");
	        layoutContainer_6.add(srhHanNm, new FormData("100%"));
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
	                    
	                    fnPopupPsnl0100() ;
	                }
	                super.componentKeyDown(event);
	            }
	         });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                    srhSystemkey.setValue("");
//	                    srhResnRegnNum.setValue("");
//	                }
//	             
//	            } 
//	      }); 
	        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
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
	        frmlytSch.setLabelWidth(1); 
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
	       // srhResnRegnNum.setFieldLabel("주민번호");
	        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
	        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.41));
	        layoutContainer_7.setBorders(false);
	        layoutContainer_5.setBorders(false);
	        
		     
		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		   lcSchCol.add(layoutContainer11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    layoutContainer_13.setLayout(new ColumnLayout()); 
		    
		    LayoutContainer layoutContainer = new LayoutContainer(); 
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer.setLayout(frmlytSch);
	  
	        //부서콤보 
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
			                	checkInsrP410001Auth("srhDeptCd", lsDeptCd); 
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
//	          srhDeptCd.getCheckBoxListHolder().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) { 
//	           //.addSelectionChangedListener(new SelectionChangedListener<ModelData>() {
//	           //    public void selectionChanged(SelectionChangedEvent<ModelData> se) {
//	                  
//	                  if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	                      Window.alert("Single click");
//	                  }
//	                   
//	                 GWT.log("v " + ce.getEvent().getType());
//	                 
//	              //  srhDeptCd.showClose(ce);
//	                   //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
////	                BaseModel bmPayCd =  se.getSelectedItem(); 
////	                if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
////	                    if (bmPayCd != null) {  
////	                       
////	                        sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));    
////	                        sysComBass0500Dto.setDeptCd((String)bmPayCd.get("deptCd")); 
////	                    }      
////	                 
////	                    //--------------------사업 불러 오는 함수 -------------------------------------------------
////	                      lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
////	                     //--------------------사업 불러 오는 함수 -------------------------------------------------
////	                      srhBusinCd.setStore(lsBusinCd); 
////	                      srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
////	                          public void handleEvent(StoreEvent<BaseModel> be) {  
////	                           //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
////	                          }
////	                      });    
////	                
////	                }  
//	               
//	               } 
//	           });
//	        srhDeptCd.addBlurHandler(new BlurHandler()
//	        {
//	          @Override
//	          public void onBlur(BlurEvent event)
//	          {
//	              Timer delayTimer = new Timer()
//	              {
//	                @Override
//	                public void run()
//	                {
//	                   //do stuff
//	                }
//	              };
//	              delayTimer.schedule(300);
//	           }
//	      });
	        layoutContainer.add(srhDeptCd, new FormData("100%"));  
//	        //검색 소속부서 코드 처리  
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
//	                      sysComBass0500Dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date())); 
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
//	        cpInsr4101.add(srhDeptCd);
//	        srhMangeDeptCd = new TextField<String>();
//	        srhMangeDeptCd.setName("srhMangeDeptCd");
//	        srhMangeDeptCd.setVisible(false);
//	        cpInsr4101.add(srhMangeDeptCd);
//	        srhMangeDeptNm = new TextField<String>();
//	        srhMangeDeptNm.setName("srhMangeDeptNm");
//	        srhMangeDeptNm.setVisible(false);
//	        cpInsr4101.add(srhMangeDeptNm);
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
	        
//	        layoutContainer.add(lccmlcDeptNm, new FormData("100%"));
	        layoutContainer.setBorders(false);
	         
	        
		    LayoutContainer layoutContainer_2 = new LayoutContainer(); 
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_2.setLayout(frmlytSch);
		    
		  //직종 직종세처리  
	        LayoutContainer lcTypOccuCd = new LayoutContainer();
	        lcTypOccuCd.setLayout(new ColumnLayout());
	           
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
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
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	        srhTypOccuCd.setFieldLabel("직종");
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
		               // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
	                		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
			                	//checkInsrP410001Auth("srhTypOccuCd", lsTypOccuCd); 
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
	      //  srhDtilOccuInttnCd.setFieldLabel("직종세");
//	        srhDtilOccuInttnCd.setLabelSeparator("");
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
	        
	        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
	        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
	        layoutContainer_21.setBorders(false);
	        
		    layoutContainer_2.add(lcTypOccuCd, new FormData("100%"));
		    layoutContainer_2.setBorders(false);
		    
		    
//		    LayoutContainer layoutContainer_10 = new LayoutContainer(); 
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(40); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_10.setLayout(frmlytSch);
//	        
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
//	        layoutContainer_10.add(srhTypOccuCd, new FormData("100%"));
//	        layoutContainer_10.setBorders(false);
	        
		    LayoutContainer layoutContainer_41 = new LayoutContainer(); 
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_41.setLayout(frmlytSch);
		    
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
		    layoutContainer_41.add(srhBusinCd, new FormData("100%"));
		    layoutContainer_41.setBorders(false);
		    fieldSet.add(layoutContainer_13);
		    layoutContainer_13.setBorders(false);
		    
		    
		    layoutContainer_13.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
		   // layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    layoutContainer_13.add(layoutContainer_41,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.29));
		    
//		    LayoutContainer layoutContainer_3 = new LayoutContainer();
//		    layoutContainer_3.setLayout(new ColumnLayout());
//		    
//		    layoutContainer_3.add(layoutContainer_1);
//		    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
//		    layoutContainer_3.setBorders(false);
//	        
//		    fieldSet.add(layoutContainer_3); 
		    
		     cpInsr4101.add(fieldSet); 
		   
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
	 
	  private  void createStandardForm() {
		  
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytStd);
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
				
				
			FieldSet fldstNewFieldset_1 = new FieldSet();
		   // fldstNewFieldset_1.setSize(628, 320);
			

			layoutContainer_2.add(fldstNewFieldset_1);
			fldstNewFieldset_1.setHeadingHtml("예외건강보험정보");
			fldstNewFieldset_1.setCollapsible(false);
			
		//	fldstNewFieldset_1.add(occupationalRTop(),new FormData("100%"));
			
			LayoutContainer layoutContainer_3 = new LayoutContainer();
			layoutContainer_3.setLayout(new ColumnLayout());
			
			FieldSet fldstNewFieldset_4 = new FieldSet();
			fldstNewFieldset_4.setCollapsible(false);
			
			LayoutContainer layoutContainer_4 = new LayoutContainer();
			 layoutContainer_4.setStyleAttribute("paddingLeft", "10px");
			frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_4.setLayout(frmlytStd);
			layoutContainer_4.add(payrLeft01(),new FormData("100%"));
			fldstNewFieldset_4.add(layoutContainer_4,new FormData("100%"));
			layoutContainer_4.setBorders(false);
			layoutContainer_3.add(fldstNewFieldset_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
			fldstNewFieldset_4.setHeadingHtml("예외처리대상자");
			 
			
			FieldSet fldstNewFieldset_5 = new FieldSet();
			
			LayoutContainer layoutContainer_5 = new LayoutContainer();
			 layoutContainer_5.setStyleAttribute("paddingLeft", "10px");
			frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_5.setLayout(frmlytStd);
			layoutContainer_5.add(payrLeft02(),new FormData("100%"));
			fldstNewFieldset_5.add(layoutContainer_5,new FormData("100%"));
			layoutContainer_5.setBorders(false);
			layoutContainer_3.add(fldstNewFieldset_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
			fldstNewFieldset_5.setHeadingHtml("예외처리내역");
			fldstNewFieldset_5.setCollapsible(false);
			fldstNewFieldset_1.add(layoutContainer_3);
			layoutContainer_3.setBorders(false);
			 
			    
			cpInsr4101.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   
		 
	  
		 
		   private  LayoutContainer payrLeft01() { 

			  
			    LayoutContainer lcStdGrid = new LayoutContainer();
			 //   lcStdGrid.setStyleAttribute("paddingRight", "10px");
			    FormLayout frmlytStd = new FormLayout();  
			  //  frmlytStd.setLabelWidth(85); 
			   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
			    lcStdGrid.setLayout(frmlytStd);  
			    
			    ContentPanel cpGrid = new ContentPanel();   
			    cpGrid.setBodyBorder(false); 
			    cpGrid.setHeaderVisible(false);   
			    cpGrid.setLayout(new FitLayout());      
			    cpGrid.setSize(320, 485);   
			    
			  	payrL0540GridPanel = new MSFGridPanel(payr0540LDef, false, false, false, false);
			  	payrL0540GridPanel.setHeaderVisible(false);  
			  	payrL0540GridPanel.setBodyBorder(true);
			  	payrL0540GridPanel.setBorders(true);
			// 	 payrL0540GridPanel.setGridType(MSFGridType.GROUPBY);
			  	//payrL0540GridPanel.setSize(598, 184);   
				    final Grid payr0540Grid = payrL0540GridPanel.getMsfGrid().getGrid(); 
				   payr0540Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
			             public void handleEvent(BaseEvent be) {  
			           	  if (payrL0540GridPanel.getCurrentlySelectedItem() != null) {  
			           		  //setRecord(payrL0540GridPanel.getCurrentlySelectedItem());	
			           		 // actionDatabase = ActionDatabase.UPDATE; 
			           		dpobCd.setValue(MSFSharedUtils.allowNulls(payrL0540GridPanel.getCurrentlySelectedItem().get("dpobCd")));
			           		systemkey.setValue(MSFSharedUtils.allowNulls(payrL0540GridPanel.getCurrentlySelectedItem().get("systemkey")));
			           		  
			           	  }
			             }
			         });  
			 				 	  

			    cpGrid.add(payrL0540GridPanel);  
			    lcStdGrid.add(cpGrid);  
			    
				return lcStdGrid;  
			   
		   }
		   
		   
		   private  LayoutContainer payrLeft02() {
			   
	 
			  
			    LayoutContainer lcStdGrid = new LayoutContainer();
			  //  lcStdGrid.setStyleAttribute("paddingRight", "10px");
			    FormLayout frmlytStd = new FormLayout();  
			  //  frmlytStd.setLabelWidth(85); 
			   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
			    lcStdGrid.setLayout(frmlytStd);  
			    
			    final ContentPanel cpGridPayrR0540 = new ContentPanel();   
			    cpGridPayrR0540.setBodyBorder(false); 
			    cpGridPayrR0540.setHeaderVisible(false);   
			    cpGridPayrR0540.setLayout(new FitLayout());      
			    cpGridPayrR0540.setSize(608, 485);   
			     
				 payrR0540GridPanel = new MSFGridPanel(payr0540RDef, false, false, false, false,false);
				 payrR0540GridPanel.setHeaderVisible(false);  
				 payrR0540GridPanel.setBodyBorder(true);
				 payrR0540GridPanel.setBorders(true);
				 // 	 payrR0540GridPanel.setGridType(MSFGridType.GROUPBY);
				 payrR0540GridPanel.setSize(608, 485);   
				 final Grid payr0540Grid = payrR0540GridPanel.getMsfGrid().getGrid(); 
				 payr0540Grid.addListener(Events.Select,  new Listener<BaseEvent>() {
					 public void handleEvent(BaseEvent be) {  
						 if (payrR0540GridPanel.getCurrentlySelectedItem() != null) {  
							 setRecord(payrR0540GridPanel.getCurrentlySelectedItem());	
							 actionDatabase = ActionDatabase.UPDATE;
						 }
					 }
				 });  
//			 				 	  

				 
			    payr0540Grid.addListener(Events.RowClick,  new Listener<BaseEvent>() {
			    	public void handleEvent(BaseEvent be) {  
			    		if (payrR0540GridPanel.getCurrentlySelectedItem() != null) {  ;
			    			payrR0540GridPanel.setGridRowFormBind(payrR0540GridPanel.getCurrentlySelectedItem());
			    			setRecord(payrR0540GridPanel.getCurrentlySelectedItem());	
			    			if(!actionDatabase.equals(ActionDatabase.INSERT)) actionDatabase = ActionDatabase.UPDATE;
			    		}
			    	}
			    });  
				 
			 cpGridPayrR0540.add(payrR0540GridPanel);   
	 
			 		 
			 cpGridPayrR0540.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {   
	 	      @Override  
	 	      public void componentSelected(ButtonEvent ce) {   
	 	    	   
	 	    	 if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	 	    		 return;
	      	     }
//	 	    	   BaseModel bm = new BaseModel();
//				   
//				   bm = payr0540GridPanel.getTableDef().getDefaultValues();
//				   RowEditor rowEdit = new RowEditor();
//				   
//				   /**================================================================================= 
//				   //인서트시 초기셋팅부분 .
//				   ====================================================================================*/ 
//				   bm.set("dpobCd", dpobCd.getValue());
//				   bm.set("systemkey", systemkey.getValue());
//				   bm.set("payItemCd", new ListStore<BaseModel>());
//				   bm.set("pymtDducItemSilNum", 0);
//				   /**================================================================================= 
//				   //인서트시 초기셋팅부분 .
//				   ====================================================================================*/ 
//				    
//				    for (int i=0;i < payr0540GridPanel.getGrid().getPlugins().size();i++) {
//				    	if (payr0540GridPanel.getGrid().getPlugins().get(i) instanceof RowEditor) {
//				    		rowEdit = (RowEditor)payr0540GridPanel.getGrid().getPlugins().get(i);
//				    		rowEdit.stopEditing(false);  
//				    		payr0540GridPanel.getGrid().getStore().insert(bm, 1);  
//				    		rowEdit.startEditing(payr0540GridPanel.getGrid().getStore().indexOf(bm), true);  
//				    	    break;
//				    	}
//				    }
	 	          
	 	     	  payrR0540GridPanel.getMsfGrid().clearData();
	             //TODO 부서에 따른 사업 및 직종처리 로직 추가해야 함
	              BaseModel bmData = payrR0540GridPanel.getTableDef().getDefaultValues();
	            
	              bmData.set("dpobCd", dpobCd.getValue());/** column 사업장코드 : dpobCd */
	              bmData.set("systemkey", systemkey.getValue());   /** column systemkey : systemkey */
	              bmData.set("exptnPrcsSeilNum",0L);     /** column 예외처리일련번호 : exptnPrcsSeilNum */
	              bmData.set("exptnDivCd",new BaseModel());    /** column 예외구분코드 : exptnDivCd */
	            
	              bmData.set("exmtnYn",true);     /** column 면제여부 : exmtnYn */
	              bmData.set("exptnPrcsPymtSum",0L);     /** column 예외처리공제금액 : exptnPrcsPymtSum */
	              bmData.set("exptnPrcsPymtRto",0.0);     /** column 예외처리공제비율 : exptnPrcsPymtRto */
	              //bmData.set("exptnPrcsBgnnDt","");     /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	             // bmData.set("exptnPrcsEndDt","");     /** column 예외처리종료일자 : exptnPrcsEndDt */
	              bmData.set("payItemCd",new BaseModel());      /** column 급여항목코드 : payItemCd */
	              bmData.set("exptnPrcsNoteCtnt","");     /** column 예외처리내용 : exptnPrcsNoteCtnt */
	              
	              payrR0540GridPanel.getMsfGrid().getGrid().stopEditing();      
	              payrR0540GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
	              payrR0540GridPanel.getMsfGrid().getGrid().startEditing(payrR0540GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
	              //payrR0540GridPanel.setSize(485, (184 - (cpGridPayrR0540.getButtonBar().getHeight() + 10)) );  
	               	              
				  actionDatabase = ActionDatabase.INSERT;
	 	      }   
	 	    }));  
	 	   
			 cpGridPayrR0540.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {   
		      @Override  
		      public void componentSelected(ButtonEvent ce) {   
		    	
		    	  //if (isValid()) {
		          boolean checkField = true;
		          
		      //    actionDatabase = ActionDatabase.UPDATE;
		    	   
	              Iterator<Record> iterRecords = payrR0540GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator(); 
	              
	              List<InfcPkgPayr0540DTO> listPayr0540dto = new ArrayList<InfcPkgPayr0540DTO>();  
	              while (iterRecords.hasNext()) {
	          
	                Record recData = (Record) iterRecords.next(); 
	                BaseModel bmMapModel = (BaseModel)recData.getModel();
	                  
	                InfcPkgPayr0540DTO payr0540Dto = new InfcPkgPayr0540DTO();  
	               
	                payr0540Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                payr0540Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                payr0540Dto.setExptnPrcsSeilNum((Long)bmMapModel.get("exptnPrcsSeilNum"));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
	                payr0540Dto.setExptnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("exptnDivCd$commCd")));    /** column 예외구분코드 : exptnDivCd */
	                payr0540Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
	                
	                payr0540Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls("B0080030"));    /** column 지급공제구분코드 : pymtDducDivCd */
	                
	                payr0540Dto.setExmtnYn((Boolean)bmMapModel.get("exmtnYn"));    /** column 면제여부 : exmtnYn */
	                payr0540Dto.setExptnPrcsPymtSum((Long)bmMapModel.get("exptnPrcsPymtSum"));    /** column 예외처리공제금액 : exptnPrcsPymtSum */
	                
	                
	               
	                
	                payr0540Dto.setExptnPrcsPymtRto((Double) bmMapModel.get("exptnPrcsPymtRto"));    /** column 예외처리공제비율 : exptnPrcsPymtRto */
	                
	                payr0540Dto.setExptnPrcsBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsBgnnDt"),"yyyyMMdd")  );    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	                payr0540Dto.setExptnPrcsEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsEndDt"),"yyyyMMdd"));    /** column 예외처리종료일자 : exptnPrcsEndDt */
	                //payr0540Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
	                //payr0540Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
	                //payr0540Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
	                //payr0540Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
	                //payr0540Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
	                //payr0540Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */
	                payr0540Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
	                payr0540Dto.setExptnPrcsNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("exptnPrcsNoteCtnt")));    /** column 예외처리내용 : exptnPrcsNoteCtnt */
	  
	                if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	                	checkField = false;
	       	            break;
	       	          }
	                listPayr0540dto.add(payr0540Dto);
	              
	            }   
	              
	            if (checkField) {
		               insrP410001Service.activityOnInsrP400001Payr0540(listPayr0540dto, 
		                                    actionDatabase,
		                                    new AsyncCallback<Long>() {
		                 
		                public void onFailure(Throwable caught) {
		                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0540(" + actionDatabase.name() + ") : " + caught), null);
		                }
		                public void onSuccess(Long result) { 
		                    
		                    reloadPayrR0540();
		                    actionDatabase = ActionDatabase.UPDATE;
		                }   
		            }); 
	            }
		        //}
		      }   
		    }));  
		    
			 cpGridPayrR0540.addButton(new Button("삭제", new SelectionListener<ButtonEvent>() {   
		 	      @Override  
		 	      public void componentSelected(ButtonEvent ce) {   
		 	    	  //if (isValid()) {
		 	    	 boolean checkField = true;
		 	    	 
		 	         Iterator<BaseModel> itBm  = payrR0540GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                 
	                 List<Record>  lsRec  = new ArrayList<Record>();
	                 
	                 while(itBm.hasNext()) {

	                     Record rec  = new Record(itBm.next()); 
	                     lsRec.add(rec);
	                     
	                 } 
	                   
	                   
	                  Iterator<Record> iterRecords = lsRec.iterator() ;   
	                      
	                  List<InfcPkgPayr0540DTO> listPayr0540dto = new ArrayList<InfcPkgPayr0540DTO>();  
	                    
	                  while (iterRecords.hasNext()) {
	                  
	                        Record recData = (Record) iterRecords.next(); 
	                        BaseModel bmMapModel = (BaseModel)recData.getModel();
	                          

	                          InfcPkgPayr0540DTO payr0540Dto = new InfcPkgPayr0540DTO();   

	                          payr0540Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                          payr0540Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                          payr0540Dto.setExptnPrcsSeilNum((Long)bmMapModel.get("exptnPrcsSeilNum"));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
	                          payr0540Dto.setExptnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("exptnDivCd$commCd")));    /** column 예외구분코드 : exptnDivCd */
	                          payr0540Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
	                          payr0540Dto.setExmtnYn((Boolean)bmMapModel.get("exmtnYn"));    /** column 면제여부 : exmtnYn */
	                          payr0540Dto.setExptnPrcsPymtSum((Long)bmMapModel.get("exptnPrcsPymtSum"));    /** column 예외처리공제금액 : exptnPrcsPymtSum */
	                          payr0540Dto.setExptnPrcsPymtRto((Double)bmMapModel.get("exptnPrcsPymtRto"));    /** column 예외처리공제비율 : exptnPrcsPymtRto */
	                          payr0540Dto.setExptnPrcsBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsBgnnDt"),"yyyyMMdd")  );    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	                          payr0540Dto.setExptnPrcsEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("exptnPrcsEndDt"),"yyyyMMdd"));    /** column 예외처리종료일자 : exptnPrcsEndDt */
	                          //payr0540Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
	                          //payr0540Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
	                          //payr0540Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
	                          //payr0540Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
	                          //payr0540Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
	                          //payr0540Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */
	                          payr0540Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
	                          payr0540Dto.setExptnPrcsNoteCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("exptnPrcsNoteCtnt")));    /** column 예외처리내용 : exptnPrcsNoteCtnt */
	            
	                          if (MSFSharedUtils.paramNull(systemkey.getValue())) {
	                          	checkField = false;
	                 	            break;
	                 	      }
	                          listPayr0540dto.add(payr0540Dto);
	                      
	                    }    
	                  
	                    if (checkField) {
			 	          	 actionDatabase = ActionDatabase.DELETE;
			 	          	insrP410001Service.activityOnInsrP400001Payr0540(listPayr0540dto, 
			 	                                    actionDatabase,
			 	                                    new AsyncCallback<Long>() {
			 	    			 
			 	                public void onFailure(Throwable caught) {
			 	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
			 	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0540(" + actionDatabase.name() + ") : " + caught), null);
			 	                }
			 	                public void onSuccess(Long result) { 
			 	                	
			 	                    reloadPayrR0540();
			 	                }	
			 	            });
	                    } 
		 	        //}
		 	      }   
		 	    }));
			    lcStdGrid.add(cpGridPayrR0540);   
			     
				return lcStdGrid;  
			   
		   }
		   

			 private void createBottom() {
				 
				 
				    topInsrP410001Bar = new ButtonBar();    
					topInsrP410001Bar.setAlignment(HorizontalAlignment.RIGHT);
		   
				  
					btnInsrP410001Init = new Button("초기화");  
				    btnInsrP410001Init.setIcon(Resources.APP_ICONS.new16());
				    topInsrP410001Bar.add(btnInsrP410001Init);
				    btnInsrP410001Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    			 //초기화 
			    			formInit();
			    		}
			        });  
				    
				    btnInsrP410001New = new Button("대상자선택");  
				    btnInsrP410001New.setIcon(Resources.APP_ICONS.new16());
				    topInsrP410001Bar.add(btnInsrP410001New);
				    btnInsrP410001New.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    			 //신규
			    			 formNew();
			    		}
			        });  
				  	 
//				    btnInsrP410001Save = new Button("저장");  
//				    btnInsrP410001Save.setIcon(Resources.APP_ICONS.save16());
//			        topInsrP410001Bar.add(btnInsrP410001Save); 
			   
			        btnInsrP410001Del = new Button("삭제");  
			        btnInsrP410001Del.setIcon(Resources.APP_ICONS.delete16());
			  	    topInsrP410001Bar.add(btnInsrP410001Del);
			  	    btnInsrP410001Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    			//조회버튼 클릭시 처리 
			    		    deleteInsrP410001(); 
			    		}
			    	});
			  	    btnInsrP410001Sreach = new Button("조회"); 
			  	    btnInsrP410001Sreach.setIcon(Resources.APP_ICONS.search16());
			  	    topInsrP410001Bar.add(btnInsrP410001Sreach);
			  	    btnInsrP410001Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			    		public void handleEvent(ButtonEvent e) {
			    			//조회버튼 클릭시 처리 
			    			reSet();
			    		    reload();  
			    		}
			    	});
			  	
//			  	    btnInsrP410001Excel = new Button("엑셀"); 
//			  	    btnInsrP410001Excel.setIcon(Resources.APP_ICONS.excel16()); 
//			  	    topInsrP410001Bar.add(btnInsrP410001Excel);  
//			    	  btnInsrP410001Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
//			    		public void handleEvent(ButtonEvent e) {
//			    			//엑셀저장  
//			    		}
//			    	});
				  	
			     cpInsr4101.add(topInsrP410001Bar);    
				  
			  	
			 } 
		    
		   
			public void reload() {
				// TODO Auto-generated method stub
				formInit(); 
				IColumnFilter filters = null;

				payrL0540GridPanel.getTableDef().setTableColumnFilters(filters);
				
				payrL0540GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				payrL0540GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
			
			     String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
	             payrL0540GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
	          // payrL0540GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhDeptCd,"deptCd")), SimpleColumnFilter.OPERATOR_EQUALS); 
	            
	             String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
	             payrL0540GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	           //payrL0540GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
	           //  String strPyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
	           //  payrL0540GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
	           //payrL0540GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	             String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
	             payrL0540GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	           //payrL0540GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);  
		         
				payrL0540GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				  
			//	payrL0540GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(srhHdofcCodtnCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS);
				 
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
		        payrL0540GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
	             
				payrL0540GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
				payrL0540GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
				payrL0540GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);   
				 
				payrL0540GridPanel.reload();
				
				actionDatabase = ActionDatabase.READ; 
			}
			
			
			//폼초기화 검색조건포함 
		   private void formInit() { 
			   
			   payrL0540GridPanel.getMsfGrid().clearData();
			   payrR0540GridPanel.getMsfGrid().clearData();
			   actionDatabase = ActionDatabase.INSERT;
			   
			   
		   }
		   
		   //대상자선택
		   private void formNew() {  
			   
			    MSFFormPanel popCom0110 = PrgmComPopupUtils.lovPopUpPrgmCom0110Form();  //인사  
			       
			       final FormBinding popBindingCom0110 = popCom0110.getFormBinding();
			      
			       popBindingCom0110.addListener(Events.Change, new Listener<BaseEvent>() {
			           public void handleEvent(BaseEvent be) {
			               List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
			               
			               if (mapModels != null) {  
			                   
			            	    if (MSFSharedUtils.paramNull(mapModels)) {
		               	            return;
		               	        } else { 
		               	        	 
		               	            insrP410001Service.activityOnInsertInsrP410001(mapModels , 
		    	           	                new AsyncCallback<Long>() {
		    	           	        public void onFailure(Throwable caught) {
		    	           	        	 
		    	           	        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		    	           	                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsertInsrP410001(insert) : " + caught), null);
		    	           	        }
		    	           	        public void onSuccess(Long result) {  
		    	           	        	
			    	           	         if (result == 0) {
			    	           	           MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
			    	           	                   "저장이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
			    	           	        } else {
			    	           	          // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
			    	           	          //          "저장이 완료되었습니다.", null);
			    	           	           reload();
			    	           	        }   
		    	           	        } 
		    	           	        });
		               	        } 
		                         actionDatabase = ActionDatabase.UPDATE; 
			                    
			               }  
			            
			               
			           }
			       });
			   
			   
			   
		   }
		   		   
		   
	 
	
	   @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            //@Override
	            public void handleEvent(BaseEvent be) {
	                 
	            }
	        });
	    }
		       
		@Override
		public boolean isValid() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onSuccessSave() {
			// TODO Auto-generated method stub
			
		} 
		
		

	   public void setRecord(BaseModel record) {
	       this.record = record;
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
	 
	 
	//예외 누른경우에 데이터를 리로딩한다.
	   private void reloadPayrR0540(){
	       if (MSFSharedUtils.paramNull(systemkey.getValue())) {
             return;
         }
		   IColumnFilter filters = null;
		   payrR0540GridPanel.getTableDef().setTableColumnFilters(filters);
			
		   payrR0540GridPanel.getTableDef().addColumnFilter("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		   payrR0540GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		   payrR0540GridPanel.reload();
	   }

 
	   private void reSet(){
		   dpobCd.clear();
		   systemkey.clear();  
	   }
	  
	 

}
