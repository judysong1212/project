/**
 * 수당/공제지급명세서 
 */
package com.app.exterms.payroll.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.form.defs.Payr0470Def;
import com.app.exterms.payroll.client.form.defs.Payr0480Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.utils.PayrUtils;
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
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
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

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
 
/**
* <pre>
* 1. 패키지명 : com.app.exterms.payroll.client.form
* 2. 타입명 : Payr4450.java
* 3. 작성일 : Nov 18, 2015 9:59:25 AM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
*/
public class Payr4450  extends MSFPanel { 



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
	  private FormPanel plFrmPayr4450;
	  //private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
			  
	 
	  private Payr0480Def payr0480Def  = new Payr0480Def("PAYR4450");   //공제 그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0480GridPanel;
	  
	  private Payr0470Def payr0470Def  = new Payr0470Def("PAYR4450");   //수당 그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel payr0470GridPanel;
	  
		
      //직종콤보
//      private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//      private MSFGridPanel typOccuCdGridPanel;
  
      //지급년도 
      private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
      private MSFGridPanel payYrGridPanel;
 
		  
	   /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 상태처리 전역변수
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ActionDatabase actionDatabase;
      
      private ContentPanel cpGrid01;
    //  private ContentPanel cpGrid02;
       
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
      private ButtonBar topPayr4450Bar;
      private Button btnPayr4450Init;
     // private Button btnPayr4450Save;
     // private Button btnPayr4450Del;
      private Button btnPayr4450Print;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr01;
      private ComboBox<BaseModel> srhPayMonth01;
      private ComboBox<BaseModel> srhPayYr02;
      private ComboBox<BaseModel> srhPayMonth02;
     
      private ComboBox<BaseModel> srhPayrMangDeptCd;	//단위기관 
      private ComboBox<BaseModel> srhEmymtDivCd; 		//고용구분
      private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드
      private MSFMultiComboBox<ModelData> srhDeptCd;	//부서 
    //  private ComboBox<BaseModel> srhDeptCd ;    //부서   
//      private TextField<String> srhDeptCd; //부서코드
//      private TextField<String> srhDeptNm; //부서명  
//      private Button btnSrhDeptCd;
//      private TextField<String> srhMangeDeptCd; //관리부서 수정
//      private TextField<String> srhMangeDeptNm; //관리부서 수정  
      
      private ComboBox<BaseModel> srhBusinCd;    //사업
//      private ComboBox<BaseModel> srhTypOccuCd; //직종  
//      private ComboBox<BaseModel> srhDtilOccuInttnCd; //직종세
//      private HiddenField<String> srhPyspGrdeCd; //직종 
      private ComboBox<BaseModel> srhPayCd;   /** column 급여구분코드 : payCd */ 
      private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
      private MSFMultiComboBox<ModelData> srhTypOccuCd; //직종  
      private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
      
      private TextField<String> srhHanNm;         //성명
      private TextField<String> srhResnRegnNum;   //주민번호 
      private HiddenField<String> srhSystemkey;   //시스템키
      
      private RadioGroup rdgrpRadiogroup ;  	//출력조건라디오그룹 
      
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
      
      private HiddenField<String> dpobCd;  //사업장코드 
     
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
   			  private void checkPayr4450Auth( String authAction, ListStore<BaseModel> bm) {   
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
                
               
                 //Date today = new Date(); 
	        	    // A custom date format
	        	  // DateTimeFormat fmt = DateTimeFormat.getFormat("MM"); 
	        	  
	        	   srhPayYr01.setValue(lsPayYrStore01.getAt(0));
	        	   srhPayYr02.setValue(lsPayYrStore02.getAt(0));
	        	  // srhPayMonth01.setValue(lsPayMonth01.getAt(Integer.parseInt(fmt.format(today)) - 1));
	        	  // srhPayMonth02.setValue(lsPayMonth02.getAt(Integer.parseInt(fmt.format(today)) - 1));
	        	  
	               
	               srhPayCd.setValue(lsPayCd.getAt(0));
	               
	           /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                  * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
                  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                  // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
                  // GWTAuthorization.formAuthPopConfig(plFrmPayr4450, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
                  // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
				//gwtAuthorization.formAuthConfig(plFrmPayr4450, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
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
   				     
   				  authMapDef.put("srhPayYr01",Boolean.FALSE); 
    			  authMapDef.put("srhPayYr02",Boolean.FALSE); 
    			  authMapDef.put("srhPayCd",Boolean.FALSE);
   				  authMapDef.put("srhPayMonth01",Boolean.FALSE); 
   				 authMapDef.put("srhPayMonth02",Boolean.FALSE); 

   				 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
   				 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);  
   				 authMapDef.put("srhDeptCd",Boolean.FALSE); 
   				//  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
   				 
   					 
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
	    private void setPayr4450FormBinding() {
	 	 
	    }        
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
        /**
         * RadioGroup 을 넘겨받아 체크된 라디오 getValueAttribute 값 리턴
         * @param radioGroup
         * @return
         */
        public static String getCheckedRadioValue(RadioGroup radioGroup){
            String v = "";
            if(radioGroup != null){
                for(int i = 0; i < radioGroup.getAll().size(); i++){
                    Radio radio = (Radio)radioGroup.getAll().get(i);
                    if(radio.getValue()){
                        v = radio.getValueAttribute();
                        break;
                    }
                }
            }
            
            return v;
        } 
        
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 *  전역함수 선언부 종료 
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/    

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
	//입력수정삭제처리 rpc 처리부     
	//private Payr4450ServiceAsync payr4450Service = Payr4550Service.Util.getInstance();	    
	  
	    private ListStore<BaseModel> lsPayYrStore01 	= new ListStore<BaseModel>();  	// 년도 
	    private ListStore<BaseModel> lsPayMonth01 		= new ListStore<BaseModel>();  	// 급여월 
	    
	    private ListStore<BaseModel> lsPayYrStore02 	= new ListStore<BaseModel>();  	// 년도 
	    private ListStore<BaseModel> lsPayMonth02 		= new ListStore<BaseModel>();  	// 급여월 
	    
		private ListStore<BaseModel> lsPayrMangDeptCd 	= new ListStore<BaseModel>();   // 단위기관
		private ListStore<BaseModel> lsEmymtDivCd 		= new ListStore<BaseModel>();  	// 고용구분
		private ListStore<BaseModel> lsRepbtyBusinDivCd = new ListStore<BaseModel>();	// 호봉제구분코드
		private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
		
		private ListStore<BaseModel> lsPayCd 			= new ListStore<BaseModel>();  	// 급여구분 
		private ListStore<BaseModel> lsDeptGpCd 		= new ListStore<BaseModel>();	// 부서직종그룹코드
		private ListStore<BaseModel> lsTypOccuCd 		= new ListStore<BaseModel>();   // 직종
		private ListStore<BaseModel> lsDeptCd 			= new ListStore<BaseModel>();   // 부서
		private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();   // 사업
		private ListStore<BaseModel> lsDtilOccuInttnCd 	= new ListStore<BaseModel>();	// 직종세
		
		private PrgmComBass0300DTO sysComBass0300Dto; 
		private PrgmComBass0150DTO sysComBass0150Dto;
		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드  
		private SysCoCalendarDTO msfCoCalendarDto;  
		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	    private PrgmComBass0320DTO sysComBass0320Dto;	//직종
		 
		private BaseModel record;
    
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
 * 	print Service 선언부 시작
 *  rex 추가로 리포트 타입변경
 *  fileName : 출력파일명 
 *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
**/
	    
	private void Payr4450Print(String fileName, String repType) {
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
		String rdaFileName = "PAYRT4450"+".mrd";
		// 보낼 파라미터
		String checkedSystemKeys = "";
		
		//검색조건
		String serarchParam = "";

		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
		String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
		 
	    serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";                 //$1
	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth01,"month") +"]";  //$2
	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr02,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth02,"month") +"]";  //$3
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";                                               //$4
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";  //$5 
		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+"]";    //$6  //$6  
		//20151212-추가 시작 
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "[]"; //$7
            } else {
            	serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$7  
            }  
		    //20151212-추가 끝 
		    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$8 
		    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$9
		    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";          //$10
			serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";                   //$11
		//	serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
		//	serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]"; 
			
			
			if ("PAYRT4451".equals(fileName) ) {
	          
				List<BaseModel> list = payr0480GridPanel.getGrid().getSelectionModel().getSelectedItems();
	          
				if(list != null && list.size() > 0){
					
					String chkkey = "";
					for(BaseModel bm : list){ 
	                  chkkey += "'"+bm.get("payExtpyCd")+"',";     
					}
					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
				}  
			} else if ("PAYRT4452".equals(fileName) ) {
	         
				List<BaseModel> list = payr0470GridPanel.getGrid().getSelectionModel().getSelectedItems();
	         
				if(list != null && list.size() > 0){
					String chkkey = "";
					
					for(BaseModel bm : list){ 
	                 chkkey += "'"+bm.get("payDducCd")+"',";   
					}
					
					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
				} 
			} 
			 
		    serarchParam += "["+checkedSystemKeys+"]";  //$12
	       
		  //20151212-변경추가 시작 
		    serarchParam += "[" + MSFMainApp.get().getUser().getUsrId() + "]";  //$13 //유우져 아이디 넘김 
			serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$14
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += "["+deptCdAuth+"]"; //$15 부서 
			serarchParam += "["+dtilOccuInttnCdAuth+"]"; //$16 직종세 
			//20151212-추가 끝 
			 
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
		//String rdaFileName = "PAYRT4450"+".reb";
		String rexFileName = "PAYRT4450"+".crf";
		// 보낼 파라미터
		String checkedSystemKeys = "";
		
		//검색조건
		String serarchParam = "";

//		    serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";			//$1
//			serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth01,"month") +"⊥";  	//$2
//			serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr02,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth02,"month") +"⊥"; 	//$3
//			serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥"; 	//$4
//			serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";  				//$5 
//			serarchParam += "⊥";	//$6
//		    serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; 		//$7
//		    serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";	//$8
//		  //  serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd") +"⊥";	//$9
//		    serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"⊥";  //$10
//		    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";		//$11
//			serarchParam += ""+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"⊥";				//$12
//			
//			if ("PAYRT4451".equals(fileName) ) { 
//				List<BaseModel> list = payr0480GridPanel.getGrid().getSelectionModel().getSelectedItems();
//	          
//				if(list != null && list.size() > 0){
//					String chkkey = "";
//					for(BaseModel bm : list){ 
//	                  chkkey += "'"+bm.get("payExtpyCd")+"',";	//급여수당코드     
//					}
//					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				}
//				
//			} else if ("PAYRT4452".equals(fileName) ) {	//공제명세서 PAYRT4450 같이 사용
//	         
//				List<BaseModel> list = payr0470GridPanel.getGrid().getSelectionModel().getSelectedItems();
//	         
//				if(list != null && list.size() > 0){
//					String chkkey = "";
//					
//					for(BaseModel bm : list){ 
//	                 chkkey += "'"+bm.get("payDducCd")+"',";	//급여공제코드   
//					}
//					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				} 
//				rexFileName = "PAYRT4450.reb";
//				//serarchParam += ""+checkedSystemKeys+"⊥";  //$13
//				//serarchParam += ""+"B0080020"+"⊥";  //$14 공제명세서
//			} 
//			serarchParam += ""+checkedSystemKeys+"⊥";  //$13
//			//serarchParam += ""+MSFSharedUtils.getSelectedComboValue(payExtpyCd,"commCd")+"⊥";  //$13
//			
//	        //TODO 확인 
//			
//			if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//				serarchParam += "⊥";  //$14
//				serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$15
//			} else {
//	          
//				//직종 권한에 대한 처리 추가 기본 처리  $14로해서 처리 할것...$14
////				if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
////						&& (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
////					serarchParam += ""+MSFConfiguration.AUTH_TYPOCCUCD_10+"⊥"; 
////				} else {
////					serarchParam += "⊥";
////				} 
//				serarchParam += "⊥";  //$15
//			}
		
		//권한 설정으로 인해 추가된 부분 
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd") ;
		String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
		String repbtyBusinDivCd = MSFSharedUtils.getSelectedComboValue(srhRepbtyBusinDivCd,"commCd") ;
		
		String deptCdAuth = MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(PayrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", ""); 
		 
	    serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";                 //$1
	    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth01,"month") +"⊥";  //$2
	    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayYr02,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth02,"month") +"⊥";  //$3
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"⊥";                                               //$4
		serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"⊥";  //$5 
		serarchParam += "" +MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")+ "⊥";    //$6MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")  //$6  
		//20151212-추가 시작 
		    if (payrMangDeptCd.equals(deptCdAuth)) { 
		    	serarchParam += "⊥"; //$7
            } else {
            	serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"⊥"; //$7  
            }  
		    //20151212-추가 끝 
		    serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"⊥";//$8 
		    serarchParam += ""+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"⊥";  //$9
		    serarchParam += ""+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"⊥";          //$10
			serarchParam += ""+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"⊥";                   //$11
		//	serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
		//	serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]"; 
			
			
			if ("PAYRT4451".equals(fileName) ) {
	          
				List<BaseModel> list = payr0480GridPanel.getGrid().getSelectionModel().getSelectedItems();
	          
				if(list != null && list.size() > 0){
					
					String chkkey = "";
					for(BaseModel bm : list){ 
	                  chkkey += "'"+bm.get("payExtpyCd")+"',";     
					}
					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
				}  
			} else if ("PAYRT4452".equals(fileName) ) {
	         
				List<BaseModel> list = payr0470GridPanel.getGrid().getSelectionModel().getSelectedItems();
	         
				if(list != null && list.size() > 0){
					String chkkey = "";
					
					for(BaseModel bm : list){ 
	                 chkkey += "'"+bm.get("payDducCd")+"',";   
					}
					
					checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
				} 
			} 
			 
		    serarchParam += ""+checkedSystemKeys+"⊥";  //$12
	       
		  //20151212-변경추가 시작 
		    serarchParam += "" + MSFMainApp.get().getUser().getUsrId() + "⊥";  //$13 //유우져 아이디 넘김 
			serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$14
			  
			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += ""+deptCdAuth+"⊥"; //$15 부서 
			serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; //$16 직종세 
			//20151212-추가 끝 		
		
			serarchParam += ""+mangeDeptCd+"⊥"; //$17 관리부서 
			serarchParam += ""+repbtyBusinDivCd+"⊥"; //$18  호봉제구분 
	      
			GWT.log("popup : " + serarchParam);
			String strParam = "" + serarchParam;
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
	}

//private void Payr4450Print(String fileName) {
//	 
//	// 출력물 디렉토리 패스경로 인사 : PSNL
//	String strDirPath = "PAYR";
//	// mrd 출력물
//	String rdaFileName = "PAYRT4450"+".mrd";
//	// 보낼 파라미터
//	String checkedSystemKeys = "";
//	
//	//검색조건
//	String serarchParam = "";
//
//	    serarchParam += "["+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"]";                 //$1
//		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth01,"month") +"]";  //$2
//		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayYr02,"payYr") + MSFSharedUtils.getSelectedComboValue(srhPayMonth02,"month") +"]";  //$3
//		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")+"]";                                               //$4
//		serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")+"]";  //$5 
//	    serarchParam += "[]";    //$6MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd")  //$6
////		serarchParam += "["+MSFSharedUtils.allowNulls(srhDeptCd.getValue())+"]";          //$7
////		serarchParam += "["+ MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd")+"]";    //$8
////		serarchParam += "["+ MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd")+"]";         //$9 
//	    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")+"]"; //$7
//	    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","typOccuCd")+"]";//$8
//	    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsTypOccuCd,MSFSharedUtils.allowNulls(srhTypOccuCd.getValue()),"typOccuNm","pyspGrdeCd") +"]";  //$9
//	    serarchParam += "["+ PayrUtils.getPrintStrToMultiData(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd") +"]";  //$10
//	    serarchParam += "["+MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd")+"]";          //$11
//		serarchParam += "["+MSFSharedUtils.allowNulls(srhSystemkey.getValue())+"]";                   //$12
//	//	serarchParam += "["+MSFSharedUtils.allowNulls(srhHanNm.getValue())+"]";
//	//	serarchParam += "["+MSFSharedUtils.allowNulls(srhResnRegnNum.getValue())+"]";
//		
//		
//      if ("PAYRT4451".equals(fileName) ) {
//          
//          List<BaseModel> list = payr0480GridPanel.getGrid().getSelectionModel().getSelectedItems();
//          
//          if(list != null && list.size() > 0){
//              String chkkey = "";
//              for(BaseModel bm : list){ 
//                  
//                  chkkey += "'"+bm.get("payExtpyCd")+"',";     
//              
//              }
//              
//              checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//              
//          }  
//     
//     } else if ("PAYRT4452".equals(fileName) ) {
//         
//         List<BaseModel> list = payr0470GridPanel.getGrid().getSelectionModel().getSelectedItems();
//         
//         if(list != null && list.size() > 0){
//             String chkkey = "";
//             for(BaseModel bm : list){ 
//                 
//                 chkkey += "'"+bm.get("payDducCd")+"',";   
//             
//             }
//             
//             checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//             
//         } 
//         
//     } 
//		 
//      serarchParam += "["+checkedSystemKeys+"]";  //$13
//      
//      if ("Y".equals(MSFMainApp.get().getUser().getPayrMangDeptYn())) {
//          
//          serarchParam += "[]";  //$14
//          serarchParam += "["+MSFMainApp.get().getUser().getPayrMangDeptYn()+"]"; //$15
//      
//      } else {
//          
//          //직종 권한에 대한 처리 추가 기본 처리  $14로해서 처리 할것...$14
//          if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd()))))
//                    && (MSFConfiguration.AUTH_TYPOCCUCD_10.equals((MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getTypOccuCd()).concat(MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getPyspGrdeCd())))))) {
//              serarchParam += "["+MSFConfiguration.AUTH_TYPOCCUCD_10+"]"; 
//          } else {
//              serarchParam += "[]";
//          } 
//          
//          serarchParam += "[]";  //$15
//      }
//      
//		GWT.log("popup : " + serarchParam);
//		String strParam = "/rp " + serarchParam;
//		
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
			    createPayr4450Form();  //화면 기본정보를 설정
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
	  public Payr4450() {
		  
			setSize("1010px", "700px");  
	  } 
	
	  public Payr4450(String txtForm) {
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
	  private void createPayr4450Form() {
		  
		plFrmPayr4450 = new FormPanel();
		plFrmPayr4450.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblPayrConst.title_Payr4450()));
		//plFrmPayr4450.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 수당/공제지급명세서");
		plFrmPayr4450.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr4450.setBodyStyleName("pad-text");
		plFrmPayr4450.setPadding(2);
		plFrmPayr4450.setFrame(true);  

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr4450(),"PAYR4450");
				}
			});
		plFrmPayr4450.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr4450.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		
		 //멀티콤보박스 닫기 
        plFrmPayr4450.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) { 
            
             //   for (Field<?>  f : ((FormPanel) plFrmPayr4100).getFields()) {
                    
            //        if (f instanceof MSFMultiComboBox<?>) {
                        
//                    if ("srhDeptCd".equals(f.getName())) {
//                        
//                    } else if ("srhHdofcCodtnCd".equals(f.getName())) {
//                        
//                    }
                        
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
        
		  topPayr4450Bar = new ButtonBar();    
		  topPayr4450Bar.setAlignment(HorizontalAlignment.RIGHT); 
	  
		  
		    btnPayr4450Init = new Button("초기화");  
		    btnPayr4450Init.setIcon(MSFMainApp.ICONS.new16());
		  	topPayr4450Bar.add(btnPayr4450Init);
		  	btnPayr4450Init.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			 //초기화
	    			formInit();
	    		}
	    	});
//		  	topBtn = new Button("저장");  
//		  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//		  	buttonBar.add(topBtn); 
//		   
//		  	topBtn = new Button("삭제");  
//		  	topBtn.setIcon(MSFMainApp.ICONS.accordion());
//		  	buttonBar.add(topBtn);
		  	 
		    btnPayr4450Print = new Button("조회"); 
		    btnPayr4450Print.setIcon(MSFMainApp.ICONS.search16());
		    topPayr4450Bar.add(btnPayr4450Print);
		    btnPayr4450Print.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) { 

	    	          String printType = getCheckedRadioValue(rdgrpRadiogroup); 
	    	          
	    			//Print버튼 클릭시 처리 
//	    			Payr4450Print(printType) ;
	    	        Payr4450Print(printType, MSFMainApp.getMsg("PayGen.ReportDivisionType"));
	    		}
	    	});
			
//		  	topBtn = new Button("인쇄"); 
//		  	topBtn.setIcon(MSFMainApp.ICONS.print16()); 
//		  	buttonBar.add(topBtn);  
	  	
	  	plFrmPayr4450.add(topPayr4450Bar);    
	   
	
		vp.add(plFrmPayr4450);
		plFrmPayr4450.setSize("990px", "680px");
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
	      
	         dpobCd = new HiddenField<String>();  //사업장코드 
	         srhSystemkey = new HiddenField<String>();   //시스템키 
	      
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
			 
			 lsPayMonth01 = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
			 lsPayMonth02 = lsPayMonth01;
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
   		  sysComBass0400Dto.setDeptDspyYn("Y");
   		  sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
   		  lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		     	   //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		             // sysComBass0400Dto.setDeptDspyYn("Y");
		              sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		              sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
		              sysComBass0400Dto.setDeptDspyYn("Y");
		              lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
		             
		              lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
		                  public void handleEvent(StoreEvent<BaseModel> be) {  
		                      mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
		                      srhDeptCd.getInitStore().add(mDtalistDeptCd);
		                      
		                  }
		              });     
		              //--------------------급여부서 불러 오는 함수 ------------------------------------------------   
	 		 
		 /**
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      * 년도 콤보박스 처리  시작
	      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
	      */
	     		   ContentPanel payYrGrid = new ContentPanel();  
	     		   payYrGrid.setVisible(false);
	     		    
	     		   //년도 콤보처리 
	     		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
	     		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
	     			       public void handleEvent(ComponentEvent be) {  
	     			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
	     			          public void handleEvent(StoreEvent<BaseModel> be) {  
	     			        	 lsPayYrStore01.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
	     			        	 lsPayYrStore02.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
	     			        	 
	     			          }  
	     			        });  
	     			       
	     			      }  
	     			    });  
	     	  
	     	payYrGrid.add(payYrGridPanel); 
	     	plFrmPayr4450.add(payYrGrid); 
		  
		    plFrmPayr4450.setLayout(new FlowLayout());
		    

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
			
		    fieldSet.setStyleAttribute("marginTop", "7px");
		   // fieldSet.setCheckboxToggle(false); 
		    
		    LayoutContainer lcSchLeft = new LayoutContainer();
		  

	        fieldSet.add(lcSchCol, new FormData("100%"));  
	        lcSchLeft.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_8 = new LayoutContainer();
	        FormLayout frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_8.setLayout(frmlytSch);
	        
	        srhPayYr01 = new ComboBox<BaseModel>(); 
	        srhPayYr01.setName("srhPayYr01");
	        srhPayYr01.setForceSelection(true);
	        srhPayYr01.setMinChars(1);
	        srhPayYr01.setDisplayField("payYrDisp");
	        srhPayYr01.setValueField("payYr");
	        srhPayYr01.setTriggerAction(TriggerAction.ALL);
	       // srhPayYr01.setEmptyText("--년도선택--");
	        srhPayYr01.setSelectOnFocus(true); 
	        srhPayYr01.setReadOnly(false);
	        srhPayYr01.setEnabled(true); 
	        srhPayYr01.setStore(lsPayYrStore01); 
	        srhPayYr01.setFieldLabel("지급기간");  
	        srhPayYr01.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        public void handleEvent(StoreEvent<BaseModel> be) {  
		        	checkPayr4450Auth("srhPayYr01",lsPayYrStore01);  
		          
		        }
		    });
	        srhPayYr01.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
	             BaseModel bmPayYr =  se.getSelectedItem(); 
	             if (bmPayYr != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
	           
	                 if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                     
	                     if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                        
	                         sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr"));
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
	        layoutContainer_8.add(srhPayYr01, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.455));
	        layoutContainer_8.setBorders(false);
	        
	        LayoutContainer layoutContainer_9 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_9.setLayout(frmlytSch);
	        
	        srhPayMonth01 = new ComboBox<BaseModel>(); 
	        srhPayMonth01.setName("srhPayMonth01");
	        srhPayMonth01.setForceSelection(true);
	        srhPayMonth01.setMinChars(1);
	        srhPayMonth01.setDisplayField("monthDisp");
	        srhPayMonth01.setValueField("month");
	        srhPayMonth01.setTriggerAction(TriggerAction.ALL);
	      //srhPayMonth01.setEmptyText("--월선택--");
	        srhPayMonth01.setSelectOnFocus(true); 
	        srhPayMonth01.setReadOnly(false);
	        srhPayMonth01.setEnabled(true); 
	        srhPayMonth01.setStore(lsPayMonth01); 
	        srhPayMonth01.setHideLabel(true);
	        lsPayMonth01.addStoreListener(new StoreListener<BaseModel>() { 
	            @Override
	            public void storeAdd(StoreEvent<BaseModel> se) {
	            	 srhPayMonth01.setValue(lsPayMonth01.getAt(Integer.parseInt(DateTimeFormat.getFormat("MM").format(new Date())) - 1));
		          
	            	checkPayr4450Auth("srhPayMonth01", lsPayMonth01); 
	            	 
	            }
	        });
	        
	        layoutContainer_9.add(srhPayMonth01, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	        layoutContainer_9.setBorders(false);
	         
	        
	        LayoutContainer layoutContainer_11 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(10); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_11.setLayout(frmlytSch);
	        
	        srhPayYr02 = new ComboBox<BaseModel>(); 
	        srhPayYr02.setName("srhPayYr02");
	        srhPayYr02.setForceSelection(true);
	        srhPayYr02.setMinChars(1);
	        srhPayYr02.setDisplayField("payYrDisp");
	        srhPayYr02.setValueField("payYr");
	        srhPayYr02.setTriggerAction(TriggerAction.ALL);
	        //srhPayYr02.setEmptyText("--년도선택--");
	        srhPayYr02.setSelectOnFocus(true); 
	        srhPayYr02.setReadOnly(false);
	        srhPayYr02.setEnabled(true); 
	        srhPayYr02.setStore(lsPayYrStore02); 
	        srhPayYr02.setLabelSeparator("~");
	        srhPayYr02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
		        public void handleEvent(StoreEvent<BaseModel> be) {  
		        	checkPayr4450Auth("srhPayYr02",lsPayYrStore02);  
		          
		        }
		    });
	        layoutContainer_11.add(srhPayYr02, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.245));
	        layoutContainer_11.setBorders(false);

	        
	        LayoutContainer layoutContainer_12 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_12.setLayout(frmlytSch);
	        
	        srhPayMonth02 = new ComboBox<BaseModel>(); 
	        srhPayMonth02.setName("srhPayMonth02");
	        srhPayMonth02.setForceSelection(true);
	        srhPayMonth02.setMinChars(1);
	        srhPayMonth02.setDisplayField("monthDisp");
	        srhPayMonth02.setValueField("month");
	        srhPayMonth02.setTriggerAction(TriggerAction.ALL);
	      //srhPayMonth02.setEmptyText("--월선택--");
	        srhPayMonth02.setSelectOnFocus(true); 
	        srhPayMonth02.setReadOnly(false);
	        srhPayMonth02.setEnabled(true); 
	        srhPayMonth02.setStore(lsPayMonth02); 
	        srhPayMonth02.setHideLabel(true);
	        lsPayMonth02.addStoreListener(new StoreListener<BaseModel>() { 
	            @Override
	            public void storeAdd(StoreEvent<BaseModel> se) {
	                srhPayMonth02.setValue(lsPayMonth02.getAt(Integer.parseInt(DateTimeFormat.getFormat("MM").format(new Date())) - 1)); 
	            	checkPayr4450Auth("srhPayMonth02", lsPayMonth02); 
	            	 
	            }
	        });
	        
//	        srhPayMonth02.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) { 
//	              
//	               
//	                
//	            }
//	        }); 
	        layoutContainer_12.add(srhPayMonth02, new FormData("100%"));
	        lcSchLeft.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
	        layoutContainer_12.setBorders(false);
	        
		   
		    LayoutContainer layoutContainer = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
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
			                	checkPayr4450Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
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
	        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
	        layoutContainer.setBorders(false);
	        
   LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_15 = new LayoutContainer();
		    
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_15.setLayout(frmlytSch);
		    
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
			                	checkPayr4450Auth("srhEmymtDivCd", lsEmymtDivCd ); 
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
		    layoutContainer_15.add(srhEmymtDivCd, new FormData("100%"));
		    layoutContainer_1.setBorders(false); 
		    layoutContainer_1.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		    
		    
		    LayoutContainer layoutContainer_101 = new LayoutContainer();
			layoutContainer_101.setBorders(false);

		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_101.setLayout(frmlytSch);
		    
		    srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
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
		    srhRepbtyBusinDivCd.setLabelSeparator("");
	       // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
		    lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	              
	            }
	        });  
		    
		    layoutContainer_101.add(srhRepbtyBusinDivCd, new FormData("100%"));
		    layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		     
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.292)); 
		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    lcSchCol.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    layoutContainer_13.setLayout(new ColumnLayout());
		     
		  //관리부서 
			LayoutContainer lcSch2_1 = new LayoutContainer();
			FormLayout frmlytSch2_1 = new FormLayout();
			frmlytSch2_1.setLabelWidth(70);
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
		    
		    
		    layoutContainer_13.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.292));
		    
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
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
			                	checkPayr4450Auth("srhDeptCd", lsDeptCd); 
	               	 }
	             
	            }
	        });    
	 
	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
	           @Override
	          public void handleEvent(ComponentEvent ce) { 
	                   
	                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	                         
	                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
	                             
	                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr"));    
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
//	              if(srhDeptCd.getValue() != null && MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))){ 
//	                 
//	                      PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//	                      sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr01,"payYr")); 
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
//	        plFrmPayr4300.add(srhDeptCd);
//	        srhMangeDeptCd = new TextField<String>();
//	        srhMangeDeptCd.setName("srhMangeDeptCd");
//	        srhMangeDeptCd.setVisible(false);
//	        plFrmPayr4300.add(srhMangeDeptCd);
//	        srhMangeDeptNm = new TextField<String>();
//	        srhMangeDeptNm.setName("srhMangeDeptNm");
//	        srhMangeDeptNm.setVisible(false);
//	        plFrmPayr4300.add(srhMangeDeptNm);
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
		    
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
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
		    srhBusinCd.setReadOnly(false);
		    srhBusinCd.setEnabled(true); 
		    srhBusinCd.setStore(lsBusinCd);
		    srhBusinCd.setFieldLabel("사업");
		    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
		    fieldSet.add(layoutContainer_13);
		    layoutContainer_13.setBorders(false);
		    
		    LayoutContainer layoutContainer_3 = new LayoutContainer();
		    layoutContainer_3.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_10.setLayout(frmlytSch);
		    
//		    srhTypOccuCd = new ComboBox<BaseModel>(); 
//		    srhTypOccuCd.setName("srhTypOccuCd");
//		    srhTypOccuCd.setForceSelection(true);
//		    srhTypOccuCd.setMinChars(1);
//		    srhTypOccuCd.setDisplayField("typOccuNm");
//		    srhTypOccuCd.setValueField("typOccuCd");
//		    srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
//		    srhTypOccuCd.setEmptyText("--직종선택--");
//		    srhTypOccuCd.setSelectOnFocus(true); 
//		    srhTypOccuCd.setReadOnly(false);
//		    srhTypOccuCd.setEnabled(true); 
//		    srhTypOccuCd.setStore(lsTypOccuCd); 
//		    srhTypOccuCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_120);
//		    srhTypOccuCd.setFieldLabel("직 종");  
		    //직종 직종세처리  
	        LayoutContainer lcTypOccuCd = new LayoutContainer();
	        lcTypOccuCd.setLayout(new ColumnLayout());
	        
	        LayoutContainer layoutContainer_211 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
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
	        layoutContainer_21.setBorders(false);
	        
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(0); 
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
//	        lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
	//
//	                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//	                 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
//	                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	                  // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
//	                  // GWTAuthorization.formAuthPopConfig(plFrmPayr4300, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
//	                  // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
//	                GWTAuthorization.formAuthConfig(plFrmPayr4300, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
//	                /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                 * 권한설정을 위한 콤보처리를 위한 메서드 종료
//	                 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//	              
//	                
//	                   
//	                
//	            }
//	        });   
//	        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                //직종변경에 따른 직종세 값 가져오기
//	                BaseModel bmTypOccuCd =  se.getSelectedItem(); 
//	                 String strTypOccuCd =  MSFSharedUtils.allowNulls(bmTypOccuCd.get("typOccuCd")) ;
//	                
//	                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//	                    sysComBass0350Dto.setTypOccuCd( strTypOccuCd);
//	                    sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd"));
//	                     if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
//	                         LsDtilOccuInttnCd = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
//	                         srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd); 
//	                   }
//	                 }   
//	              
//	            } 
//	        }); 
	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
	        srhTypOccuCd.setName("srhTypOccuCd"); 
	        srhTypOccuCd.setEmptyText("--직종선택--"); 
	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
	        srhTypOccuCd.setWidth(100);
	        srhTypOccuCd.setLabelSeparator("");
//	        srhTypOccuCd.setFieldLabel("직종");
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
			                	//checkPayr4450Auth("srhTypOccuCd", lsTypOccuCd); 
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
	        srhDtilOccuInttnCd.setFieldLabel("");
	        srhDtilOccuInttnCd.setLabelSeparator("");
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
	       
	        
		    layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		    layoutContainer_10.setBorders(false);
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(70); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    layoutContainer_14.setLayout(frmlytSch);
		    
		    srhPayCd =  new ComboBox<BaseModel>(); 
		    srhPayCd.setName("srhPayCd");
		    srhPayCd.setForceSelection(true);
		    srhPayCd.setMinChars(1);
		    srhPayCd.setDisplayField("commCdNm");
		    srhPayCd.setValueField("commCd");
		    srhPayCd.setTriggerAction(TriggerAction.ALL);
		    srhPayCd.setEmptyText("---전 체---");
		    srhPayCd.setSelectOnFocus(true); 
		    srhPayCd.setReadOnly(false);
		    srhPayCd.setEnabled(true); 
		    srhPayCd.setStore(lsPayCd);
		    srhPayCd.setFieldLabel("급여구분");
		    srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  
	            	checkPayr4450Auth("srhPayCd",lsPayCd);   
	            }
	        }); 
		    
		    layoutContainer_14.add(srhPayCd, new FormData("100%"));
		   
		    layoutContainer_14.setBorders(false);
		    
		    
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
//	              
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
//		    srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
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
		    frmlytSch.setDefaultWidth(0);
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_7.setLayout(frmlytSch);
		    
		    srhResnRegnNum = new TextField<String>();
		    srhResnRegnNum.setName("srhResnRegnNum");
		    srhResnRegnNum.setHideLabel(true);
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
		   // srhResnRegnNum.setFieldLabel("주민번호");
		    layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		    layoutContainer_7.setBorders(false); 
		    layoutContainer_5.setBorders(false);
		     
		    layoutContainer_3.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		    layoutContainer_3.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.21));
		    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    
		    
		    fieldSet.add(layoutContainer_3);
		    layoutContainer_3.setBorders(false);
		     
		     
			
		    plFrmPayr4450.add(fieldSet); 
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
   * 그리드 처리 함수 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 
	  private void createCheckBoxGrid() {   
  
	        FieldSet fieldSetGrid = new FieldSet();  
		    fieldSetGrid.setHeadingHtml("수당/공제출력항목");
		    fieldSetGrid.setStyleAttribute("marginTop", "10px");
		    
		    FieldSet fieldSet_1 = new FieldSet();
		    
		    LayoutContainer layoutContainer = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer.setLayout(frmlytSch);
		    
		    Listener<BaseEvent> rdo01Listener = new Radio01boxListener(); 
		    Listener<BaseEvent> rdo02Listener = new Radio02boxListener(); 
		    rdgrpRadiogroup = new RadioGroup();
		    rdgrpRadiogroup.setBorders(false);
		    
		    Radio  rdRadio01 = new Radio();
		    rdRadio01.setValue(true);
		    rdgrpRadiogroup.add(rdRadio01);
		    rdRadio01.setBoxLabel("수당명세서");
		    rdRadio01.addListener(Events.OnClick, rdo01Listener); 
		    rdRadio01.setHideLabel(true);
		    rdRadio01.setValueAttribute("PAYRT4451"); 
//		    rdRadio01.setValueAttribute("PAYRT4450"); 
		    
		    Radio rdRadio02 = new Radio(); 
		    rdgrpRadiogroup.add(rdRadio02);
		    rdRadio02.setBoxLabel("공제명세서");
		    rdRadio02.addListener(Events.OnClick, rdo02Listener); 
		    rdRadio02.setHideLabel(true);
		    rdRadio02.setValueAttribute("PAYRT4452");
		     
		    layoutContainer.add(rdgrpRadiogroup, new FormData("100%"));
		    rdgrpRadiogroup.setFieldLabel("출력조건");
		    fieldSet_1.add(layoutContainer);
		    layoutContainer.setLayout(new FlowLayout(5));
		    layoutContainer.setBorders(true);

		    
		    plFrmPayr4450.add(fieldSet_1); 
		    fieldSet_1.setHeadingHtml("출력조건");
		    fieldSet_1.setStyleAttribute("marginTop", "10px");
		    fieldSet_1.setCollapsible(false);
		   
		    LayoutContainer lcStdGrid = new LayoutContainer();
	        //  lcStdGrid.setStyleAttribute("paddingRight", "10px"); 
	          FormLayout frmlytStd = new FormLayout();   
	          lcStdGrid.setLayout(frmlytStd);  
	          
	          cpGrid01 = new ContentPanel();   
	          cpGrid01.setBodyBorder(false); 
	          cpGrid01.setHeaderVisible(false);   
	          cpGrid01.setLayout(new FitLayout());      
	          cpGrid01.setSize(950, 400);   

	          //msfCustomForm.setHeaderVisible(false);
	          //Instantiate the GridPanel
	          payr0480GridPanel = new MSFGridPanel(payr0480Def, false, false, false, true,false); 
	          payr0480GridPanel.setHeaderVisible(false);  
	          payr0480GridPanel.setBodyBorder(true);
	          payr0480GridPanel.setBorders(true);
	          payr0480GridPanel.setSize(950, 430);  
	       //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	      
	          cpGrid01.add(payr0480GridPanel); 
	         // cpGrid01.show();
	          
	         //  cpGrid02 = new ContentPanel();   
	        //   cpGrid02.setBodyBorder(false); 
	        //   cpGrid02.setHeaderVisible(false);   
	        //   cpGrid02.setLayout(new FitLayout());      
	        //   cpGrid02.setSize(935, 380);   
	          //msfCustomForm.setHeaderVisible(false);
	          //Instantiate the GridPanel
	          payr0470GridPanel = new MSFGridPanel(payr0470Def, false, false, false, true,false);
	          payr0470GridPanel.setHeaderVisible(false);  
	          payr0470GridPanel.setBodyBorder(true);
	          payr0470GridPanel.setBorders(true);
	           payr0470GridPanel.setSize(935, 380); 
	       //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	      
	          cpGrid01.add(payr0470GridPanel); 
	      //    cpGrid02.hide();
	 
	          lcStdGrid.add(cpGrid01);   
	       //   lcStdGrid.add(cpGrid02);   

	          fieldSetGrid.add(lcStdGrid);     
		      plFrmPayr4450.add(fieldSetGrid);
		     
		  }  
	  
	   //전체선택 체크박스 
      public class Radio01boxListener implements Listener<BaseEvent>
      {
          public void handleEvent(BaseEvent be) {
              Radio radiochk = (Radio) be.getSource();
              if (radiochk.getValue()) {
                  reloadPayr0480();
                 // cpGrid01.show();
                 // cpGrid02.hide();
                  payr0480GridPanel.show();
                  payr0470GridPanel.hide();
              } else {
                 // cpGrid01.hide();
            	  payr0480GridPanel.hide();
              }
          }
      }   
      
      //전체선택 체크박스 
      public class Radio02boxListener implements Listener<BaseEvent>
      {
          public void handleEvent(BaseEvent be) {
              Radio radiochk = (Radio) be.getSource();
              if (radiochk.getValue()) {
                  reloadPayr0470();
                 // cpGrid01.hide();
                 // cpGrid02.show();
                  payr0480GridPanel.hide();
                  payr0470GridPanel.show();
              } else {
                 // cpGrid02.hide(); 
            	  payr0470GridPanel.hide();
              }
          }
      }    
	  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	  
	public void reloadPayr0480() {
			// TODO Auto-generated method stub 
  		    IColumnFilter filters = null;
			payr0480GridPanel.getTableDef().setTableColumnFilters(filters);
			 
			payr0480GridPanel.reload();
		}
	  
	public void reloadPayr0470() {
		// TODO Auto-generated method stub
 
		IColumnFilter filters = null;
		payr0470GridPanel.getTableDef().setTableColumnFilters(filters); 
		payr0470GridPanel.reload();
	}
  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 

	   private Payr4450 getThis(){
	       return this;
	   }
	   
	   //폼초기화 검색조건포함 
	   private void formInit() {
		   BaseModel bmInit = new BaseModel();
		
//		   srhPayYr01.setValue(bmInit);
//		   srhPayMonth01.setValue(bmInit);
//		   srhPayYr02.setValue(bmInit);
//		   srhPayMonth02.setValue(bmInit); 
//
//		   srhTypOccuCd.setValue(bmInit); //직종 
//		  
//		   srhEmymtDivCd.setValue(bmInit); //고용구분 
//		   srhPayrMangDeptCd.setValue(bmInit); //단위기관
//
//		   srhDeptCd.setValue(bmInit) ;    //부서 
//		   srhBusinCd.setValue(bmInit);    //사업
		   
		   srhHanNm.setValue("");         //성명
		   srhResnRegnNum.setValue("");   //주민번호 
		   srhSystemkey.setValue("");   //시스템키
		    
		   payr0480GridPanel.reload();
           cpGrid01.show();
		   payr0470GridPanel.getMsfGrid().clearData();
		    
		   
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
	   
       //부서 
//       private void fnPopupCommP140(String deptCd) {
//           //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//           //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//           //검색.처리하면됨.
//           
//           MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//           
//           final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//          
//           popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//               public void handleEvent(BaseEvent be) {
//                   BaseModel mapModel = (BaseModel)be.getSource();
//                   if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//                        
//                       srhMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
//                       srhMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNmRtchnt")));  
//                       srhDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                       srhDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                       srhDeptCd.fireEvent(Events.Add);
//                   }  
//                        
//               }
//           });
//       }       
       
       
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
